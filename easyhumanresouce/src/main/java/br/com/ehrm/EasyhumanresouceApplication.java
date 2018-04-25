package br.com.ehrm;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceContext;
import javax.servlet.Filter;
import javax.sql.DataSource;

import org.hibernate.MultiTenancyStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import br.com.ehrm.multitenant.DataSourceBasedMultiTenantConnectionProviderImpl;
import br.com.ehrm.multitenant.MultiTenantConstants;
import br.com.ehrm.multitenant.MultiTenantFilter;
import br.com.ehrm.multitenant.TenantIdentifierResolver;

@SpringBootApplication
public class EasyhumanresouceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(EasyhumanresouceApplication.class);

	@Autowired
	DataSourceBasedMultiTenantConnectionProviderImpl dsProvider;

	@Autowired
	TenantIdentifierResolver tenantResolver;

	@Autowired
	AutowireCapableBeanFactory beanFactory;

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@PersistenceContext
	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
		Map<String, Object> props = new HashMap<>();
		props.put("hibernate.multiTenancy", MultiTenancyStrategy.DATABASE.name());
		props.put("hibernate.multi_tenant_connection_provider", dsProvider);
		props.put("hibernate.tenant_identifier_resolver", tenantResolver);

		LocalContainerEntityManagerFactoryBean result = builder.dataSource(dataSource())
				.persistenceUnit(MultiTenantConstants.TENANT_KEY).properties(props)
				.packages("br.com.heiderlopes.demomultitenant").build();
		result.setJpaVendorAdapter(jpaVendorAdapter());
		return result;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(false);
		return hibernateJpaVendorAdapter;
	}

	@Bean
	public FilterRegistrationBean myFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		Filter tenantFilter = new MultiTenantFilter();
		beanFactory.autowireBean(tenantFilter);
		registration.setFilter(tenantFilter);
		registration.addUrlPatterns("/*");
		return registration;
	}

	public static void main(String[] args) {
		SpringApplication.run(EasyhumanresouceApplication.class, args);
		LOGGER.debug("--Application Started--");
	}
}

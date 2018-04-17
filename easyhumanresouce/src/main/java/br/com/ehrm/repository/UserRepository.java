package br.com.ehrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ehrm.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

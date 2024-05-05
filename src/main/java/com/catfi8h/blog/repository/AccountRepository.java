package com.catfi8h.blog.repository;

import com.catfi8h.blog.repository.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	Optional<Account> findOneByEmail(String email);
}

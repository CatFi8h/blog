package com.catfi8h.blog.repository;

import com.catfi8h.blog.repository.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	Account findByUsername(String username);
}

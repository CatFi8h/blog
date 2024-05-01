package com.catfi8h.blog.repository;

import com.catfi8h.blog.entities.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<BlogUser, Integer> {
	BlogUser findByUsername(String username);
}

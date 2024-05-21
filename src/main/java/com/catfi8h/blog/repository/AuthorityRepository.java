package com.catfi8h.blog.repository;

import com.catfi8h.blog.repository.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {

	Optional<Authority> findByName(String name);

}

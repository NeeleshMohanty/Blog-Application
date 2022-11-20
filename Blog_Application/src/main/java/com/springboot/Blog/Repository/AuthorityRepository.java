package com.springboot.Blog.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Blog.models.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
	
}

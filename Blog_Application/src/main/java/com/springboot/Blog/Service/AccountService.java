package com.springboot.Blog.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.Blog.Repository.AccountRepository;
import com.springboot.Blog.Repository.AuthorityRepository;
import com.springboot.Blog.models.Account;
import com.springboot.Blog.models.Authority;

@Service
public class AccountService {
	@Autowired
    private PasswordEncoder passwordEncoder;

   

    @Autowired
    private AuthorityRepository authorityRepository;
	 @Autowired
	    private AccountRepository accountRepository;
	 
	 public Account save(Account account) {
		 if (account.getId() == null) {
	            if (account.getAuthorities().isEmpty()) {
	                Set<Authority> authorities = new HashSet<>();
	                authorityRepository.findById("ROLE_USER").ifPresent(authorities::add);
	                account.setAuthorities(authorities);
	            }
	        }

	        account.setPassword(passwordEncoder.encode(account.getPassword()));
	        return accountRepository.save(account);
		 //return accountRepository.save(account);
		 
	 }
	 public Optional<Account> findOneByEmail(String email) {
	        return accountRepository.findOneByEmailIgnoreCase(email);
	    }
	 }
	



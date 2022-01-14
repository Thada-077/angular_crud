package com.example.cruduser.services;

import java.util.ArrayList;

import com.example.cruduser.model.Login;
import com.example.cruduser.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private LoginRepo loginRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Login login = loginRepo.findByUsername(username);
		String user = login.getUserName();
		String pass = login.getPassword();
		if (user.equals(username)) {
			return new User(user, pass,new ArrayList<>()) ;

		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
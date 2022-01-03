package com.example.cruduser.services;

import java.util.ArrayList;

import com.example.cruduser.model.Login;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	Login login = new Login();
	String username = login.getUserName();
	String password = login.getPassword();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username.equals(username)) {
			return new User(username, "$2a$10$ixlPY3AAd4ty1l6E2IsQ9OFZi2ba9ZQE0bP7RFcGIWNhyFrrT3YUi",new ArrayList<>()) ;

		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
package by.dreamlineproject.dreamline.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import by.dreamlineproject.dreamline.entities.User;

public class UserDetailsImpl implements UserDetails {
	
	private User user;
	
	public UserDetailsImpl(User user) {
		this.user = user;
	}
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.stream(user.getRole().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

}

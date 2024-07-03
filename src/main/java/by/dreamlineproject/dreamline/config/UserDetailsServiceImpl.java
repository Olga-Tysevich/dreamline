package by.dreamlineproject.dreamline.config;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import by.dreamlineproject.dreamline.entities.User;
import by.dreamlineproject.dreamline.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByName(username);
		
		return user.map(UserDetailsImpl::new)
				.orElseThrow(() -> new UsernameNotFoundException(username + " not found!"));
	}
}

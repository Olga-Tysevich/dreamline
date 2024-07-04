package by.dreamlineproject.dreamline.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import by.dreamlineproject.dreamline.entities.User;
import by.dreamlineproject.dreamline.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

   
    public User save(User user) {
        return repository.save(user);
    }


   
    public User create(User user) {
        if (repository.existsByName(user.getName())) {
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }

        return save(user);
    }

    
    public User getByName(String username) {
        return repository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

    }

    
//    public UserDetailsService userDetailsService() {
//        return this::getByName;
//    }

 
    public User getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByName(username);
    }



    @Deprecated
    public void getAdmin() {
        var user = getCurrentUser();
        user.setRole("ROLE_ADMIN");
        save(user);
    }
}
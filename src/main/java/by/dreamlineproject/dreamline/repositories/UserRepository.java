package by.dreamlineproject.dreamline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import by.dreamlineproject.dreamline.entities.User;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByName(String name);
	
	boolean existsByName(String username);
	
}
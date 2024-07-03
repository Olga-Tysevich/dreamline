package by.dreamlineproject.dreamline.controllers;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "This is unprotected page";
	}
	
	@GetMapping("/users")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String pageForUser() {
		return "This is page for user";
	}
	
	@GetMapping("/admins")
	@PreAuthorize("hasAuthority('ROLE_ADMIN")
	public String pageForAdmin() {
		return "This is page for admin";
	}
	
	@GetMapping("/all")
	public String pageForAll() {
		return "This is page for all employees";
	}
}

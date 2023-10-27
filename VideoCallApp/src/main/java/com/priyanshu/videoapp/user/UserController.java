package com.priyanshu.videoapp.user;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j

public class UserController {
	private final UserService service;

	@PostMapping
	public void register(@RequestBody User user) {
		service.register(user);
	}

	@PostMapping("/login")
	public User login(User user) {
		return service.login(user);
	}

	@PostMapping("/logout")
	public void logout(String email) {
		service.logout(email);
	}

	@GetMapping
	public List<User> findAll() {
		return service.findAll();
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handle(Exception ex) {
		ex.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
	}

}

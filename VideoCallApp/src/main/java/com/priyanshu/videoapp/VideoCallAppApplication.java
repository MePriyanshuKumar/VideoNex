package com.priyanshu.videoapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.priyanshu.videoapp.user.User;
import com.priyanshu.videoapp.user.UserService;

@SpringBootApplication
public class VideoCallAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoCallAppApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(UserService service) {
		return args -> {
			service.register(User.builder().username("Priyanshu").email("priyanshu@mail.com").password("aaa").build());

			service.register(User.builder().username("Raman").email("Raman@mail.com").password("aaa").build());

			service.register(User.builder().username("Ashu").email("ashu@mail.com").password("aaa").build());
		};
	}

}

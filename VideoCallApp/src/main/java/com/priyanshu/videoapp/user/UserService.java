package com.priyanshu.videoapp.user;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import lombok.experimental.var;

@Service
public class UserService {
	private static final List<User> USERS_LIST = new ArrayList<>();

	public void register(User user) {

		user.setStatus("online");
	}

	public User login(User user) {
		var userIndex = IntStream.range(0, USERS_LIST.size())
				.filter(i -> USERS_LIST.get(i).getEmail().equals(user.getEmail())).findAny()
				.orElseThrow(() -> new RuntimeException("User not found"));

		var cUser = USERS_LIST.get(userIndex);
		if (!cUser.getPassword().equals(user.getPassword())) {
			throw new RuntimeException("Password incorrect");
		}
		cUser.setStatus("online");
		return cUser;
	}

	public void logout(String email) {
		var userIndex = IntStream.range(0, USERS_LIST.size()).filter(i -> USERS_LIST.get(i).getEmail().equals(email))
				.findAny().orElseThrow(() -> new RuntimeException("User not found"));

	}
	public List<User>findAll(){
		return USERS_LIST;
	}

}

package com.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.demo.entity.User;
import com.demo.repo.UserRepo;

@SpringBootApplication
@EnableAsync
public class RestFullApp1Application implements CommandLineRunner {
	@Autowired
	private UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(RestFullApp1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Phat", "Khanh Hoa", "0928644923", "admin", "123123", Arrays.asList("ROLE_ADMIN"));
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		if (userRepo.findById((long) 1).isEmpty())
			userRepo.save(user);
	}
} 

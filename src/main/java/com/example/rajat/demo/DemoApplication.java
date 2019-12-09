package com.example.rajat.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Add imports

import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private JdbcTemplate jdbcTemplate;
	//@GetMapping("/")
	/*public String hello() {
		return "hello rajat!";
	}*/
    public DemoApplication(JdbcTemplate jdbcTemplate){this.jdbcTemplate =jdbcTemplate;}
	@GetMapping("/getTuples")
	public List<String> getTuples() {
		return this.jdbcTemplate.queryForList("SELECT * FROM users").stream()
				.map((m) -> m.values().toString())
				.collect(Collectors.toList());
	}
}
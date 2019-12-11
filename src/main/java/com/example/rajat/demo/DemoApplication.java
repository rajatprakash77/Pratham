package com.example.rajat.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Add imports

import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class DemoApplication {

	private JdbcTemplate jdbcTemplate;
	//@GetMapping("/")
	/*public String hello() {
		return "hello rajat!";
	}*/
    public DemoApplication(JdbcTemplate jdbcTemplate){this.jdbcTemplate =jdbcTemplate;}
	@GetMapping("/")
	public List<String> getTuples() {
		return this.jdbcTemplate.queryForList("SELECT * FROM user_details").stream()
				.map((m) -> m.values().toString())
				.collect(Collectors.toList());
	}
}
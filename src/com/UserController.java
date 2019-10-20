package com;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping(value="/Mongo")
public class UserController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	private final UserDAL userDAL;

	
	public UserController(UserDAL userDAL) {
		this.userDAL = userDAL;
	}
	
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public User addNewUsers(@RequestBody User user) {
		LOG.info("Saving user.");
		return userDAL.addNewUser(user);
	}
	@GetMapping(value = "")
	public List<User> getAllUsers() {
		LOG.info("Getting all users.");
		return userDAL.getAllUsers();
	}
	@GetMapping(value = "/{userId}")
	public User getUser(@PathVariable String userId) {
		LOG.info("Getting user with ID: {}.", userId);
		return userDAL.getUserById(userId);
	}
}

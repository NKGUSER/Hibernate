package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootApp  {

	@Autowired
	SoccerService soccerService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public String hello() {
		return "{\"data\":\"Hello World\"}";
	}
	@GetMapping(value = "/Player/{name}/{position}/{team}")
	public String Add(@PathVariable("name") final String name, 
			          @PathVariable("position") final String position,
			          @PathVariable("team") final int team) {
		
		soccerService.addBarcelonaPlayer(name, position, team);
		return "Success";
	}
	
	@GetMapping(value = "/Team/{id}")
	public String find(@PathVariable("id") final int id) {
	
		    StringBuilder pName = new StringBuilder();
		    String name = null;
			List<String> players = soccerService.getAllTeamPlayers(id);
	        for(String player : players)
	        {
	         pName.append(player);
	        } 
	        name = pName.toString();
	        return name==null? "not found" : name;
	}
	
	@GetMapping("*")
	@ResponseBody
	public String fallbackMethod(){
		return "fallback method";
	}
}
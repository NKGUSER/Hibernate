package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootApp  {

	@Autowired
	SoccerService soccerService;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SpringBootApp.class, args);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public String hello() {
		return "{\"data\":\"Hello World\"}";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/Player/{name}/{position}/{team}")
	public String Add(@PathVariable("name") final String name, 
			          @PathVariable("position") final String position,
			          @PathVariable("team") final int team) {
		
		soccerService.addBarcelonaPlayer(name, position, team);
		return "Success";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Team/{id}")
	public String find(@PathVariable("id") final int id) {
		
	
		    String Pname = null;
			List<String> players = soccerService.getAllTeamPlayers(id);
	        for(String player : players)
	        {
	         Pname += player;
	        }
	        return Pname==null? "not found" : Pname;
	}
	
	@RequestMapping("*")
	@ResponseBody
	public String fallbackMethod(){
		return "fallback method";
	}
}
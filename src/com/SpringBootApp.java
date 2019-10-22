package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import net.minidev.json.JSONObject;

@SpringBootApplication
@ComponentScan({"config","com","secure","security","Test"})
@RestController
public class SpringBootApp  {

	@Autowired
	SoccerService soccerService;
	
	public static void main(String[] args) throws JsonProcessingException {
		ApplicationContext ctx = SpringApplication.run(SpringBootApp.class, args);
		
//		for (String name: ctx.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }
		
//		ObjectMapper mapper = new ObjectMapper();
//		JsonNode rootNode = mapper.createObjectNode();
//
//		JsonNode childNode1 = mapper.createObjectNode();
//		((ObjectNode) childNode1).put("name1", "val1");
//		((ObjectNode) childNode1).put("name2", "val2");
//		
//
//		((ObjectNode) rootNode).set("obj1", childNode1);
//
//		JsonNode childNode2 = mapper.createObjectNode();
//		((ObjectNode) childNode2).put("name3", "val3");
//		((ObjectNode) childNode2).put("name4", "val4");
//
//		((ObjectNode) rootNode).set("obj2", childNode2);
//
//		JsonNode childNode3 = mapper.createObjectNode();
//		((ObjectNode) childNode3).put("name5", "val5");
//		((ObjectNode) childNode3).put("name6", "val6");
//
//		((ObjectNode) rootNode).set("obj3", childNode3);
//
//
//		String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
//		System.out.println(jsonString);
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
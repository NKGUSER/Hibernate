package com;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Consumewebsvc {

	@Autowired
	RestTemplate rt;

	@RequestMapping(value = "/getworld")
	public String getworld() {
		HttpHeaders hd = new HttpHeaders();
		hd.setAccept(Arrays.asList( MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(hd);
		return rt.exchange("http://localhost:8000/world", HttpMethod.GET, entity, String.class).getBody();	
	}
}



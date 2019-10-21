package secure;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.JwtUser;
import security.JwtGenerator;

@RestController
@RequestMapping("/token")
public class TokenController {
	
	private JwtGenerator jwtGenerator;
	
	public TokenController(JwtGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}
	
	@PostMapping
	public String generate(@RequestBody final JwtUser jwtuser) {
		return jwtGenerator.generate(jwtuser);	
	}

}

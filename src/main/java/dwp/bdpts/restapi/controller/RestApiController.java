package dwp.bdpts.restapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import dwp.bdpts.restapi.distance.UserService;
import dwp.bdpts.restapi.model.User;

@RestController
public class RestApiController {

	Logger log = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	UserService userService;
	
	@Value("${bdpts.api.url}")
	private String apiUri;
	
	@GetMapping(value = "/users/london", produces = "application/json")
	public User[] getLondonUsers() {
		log.info("Retrieving London users only");
		ResponseEntity<User[]> response = restTemplate.getForEntity(apiUri + "/city/London/users", User[].class);
		return response.getBody();
	}

	@GetMapping(value = "/users/london/within/50", produces = "application/json")
	public List<User> getUsersInOrWithin50MilesOfLondon() {
		log.info("Retrieving users within 50 miles of London");
		ResponseEntity<User[]> response = restTemplate.getForEntity(apiUri + "/users", User[].class);
		User[] users = response.getBody();
		return userService.findUsersWithinNMilesOfLondon(50, users);
	}

	// GET '/user{id}' is not exposed as it was not a requirement. Only expose the minimum.
	
}

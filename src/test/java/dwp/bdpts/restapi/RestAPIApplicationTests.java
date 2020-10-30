package dwp.bdpts.restapi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class RestAPIApplicationTests {

	@Autowired
	private RestTemplate restTemplate;
	
	@Test
	void contextLoads() {
		assertThat(restTemplate).isNotNull();
	}
	
	// Further testing to be added for: 
	// * checking Http Status 200 return code on API calls (both APIs)
	// * Unit test via Mocking http responses
	// * Integration test to calls our controller API endpoints
	// * Integration test to call the remote API endpoints
	

}

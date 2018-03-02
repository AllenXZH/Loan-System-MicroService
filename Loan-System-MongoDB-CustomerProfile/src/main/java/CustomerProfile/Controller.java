package CustomerProfile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class Controller {
	
	@Autowired
	ProfileService profileService;
	
	@Value("${HystrixErrorThresholdPercentage}")
	String ErrorPercentage;
	
	@HystrixCommand(fallbackMethod="defaultFallback", 
					commandProperties={
							@HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="50")})
	@RequestMapping(path="/profile", method=RequestMethod.POST)
	public ResponseEntity<Customer> findCustomerByUsernameAndPassword(@RequestParam String username, @RequestParam String password){
		System.out.println("HystrixErrorThresholdPercentage: "+ErrorPercentage);
		Customer  customer = profileService.findByUsernameAndPassword(username, password);
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	public Customer defaultFallback(@RequestParam String username, @RequestParam String password) {
		return null;
	}
	
}

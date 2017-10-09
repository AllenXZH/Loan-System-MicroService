package customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import customer.client.CustomerProfileClient;
import customer.entity.Customer;
import customer.repository.CustomerRepository;

@RestController
@SessionAttributes("customerId")
public class LoginController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerProfileClient customerProfileClient; //Hystrix Client;
	
	
	
	@HystrixCommand(fallbackMethod="defaultFallback", 
			commandProperties={@HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="20")})
	@RequestMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, ModelMap map) {
		
		Customer customer;
		//customer = customerRepository.findByUsernameAndPassword(username, password);
		customer = customerProfileClient.findCustomerByUserNameAndPassword(username, password);
		if (customer == null) {
			return "login fail";
		}
		//map.put("customerId", customer.getId());
		
		return "hello " + customer.getUsername();
		
	}
	
	
	public String defaultFallback(@RequestParam String username, @RequestParam String password, ModelMap map) {
		return "login service not available";
	}

}

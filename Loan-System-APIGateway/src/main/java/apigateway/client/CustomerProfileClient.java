package apigateway.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import apigateway.entity.Customer;

@FeignClient(value = "CustomerProfile", fallback = CustomerProfileClientFallback.class)
public interface CustomerProfileClient {
	
	@RequestMapping(path="/profile", method=RequestMethod.POST)
	Customer findCustomerByUserNameAndPassword(@RequestParam("username") String username, 
			@RequestParam("password") String password);
	
}

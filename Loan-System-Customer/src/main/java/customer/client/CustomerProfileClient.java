package customer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import customer.entity.Customer;

//@FeignClient(url="localhost:4444", name="CustomerProfile", fallback = CustomerProfileClientFallback.class)
@FeignClient(value = "customer-profile", fallback = CustomerProfileClientFallback.class)
public interface CustomerProfileClient {
	
	@RequestMapping(path="/CustomerProfile/profile", method=RequestMethod.POST)
	ResponseEntity<Customer> findCustomerByUserNameAndPassword(@RequestParam("username") String username, 
			@RequestParam("password") String password);
	
}

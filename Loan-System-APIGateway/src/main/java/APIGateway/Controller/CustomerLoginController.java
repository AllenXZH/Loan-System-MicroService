package APIGateway.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import APIGateway.client.CustomerProfileClient;
import APIGateway.entity.Customer;

@Controller
public class CustomerLoginController {
	
	@Autowired
	CustomerProfileClient customerProfileClient;
	
	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		if (username == null || password == null) {
			return "error";
		}
		Customer customer;
		customer = customerProfileClient.findCustomerByUserNameAndPassword(username, password);
		if (customer == null) {
			return "login failed";
		}
		System.out.println("hello: " + customer.getId());
		return "index";
	}
}

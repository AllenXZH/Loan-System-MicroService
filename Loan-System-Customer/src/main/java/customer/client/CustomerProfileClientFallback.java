package customer.client;

import org.springframework.stereotype.Component;

import customer.entity.Customer;

@Component
public class CustomerProfileClientFallback implements CustomerProfileClient {

	@Override
	public Customer findCustomerByUserNameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

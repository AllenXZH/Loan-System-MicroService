package customer.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import customer.entity.Customer;

@Component
public class CustomerProfileClientFallback implements CustomerProfileClient {

	@Override
	public ResponseEntity<Customer> findCustomerByUserNameAndPassword(String username, String password) 
			throws Exception{
		// TODO Auto-generated method stub
		throw new Exception("client services not available");
	}
	
}

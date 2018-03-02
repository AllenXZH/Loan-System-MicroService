package customer.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import customer.entity.Customer;

@Component
public class CustomerProfileClientFallback implements CustomerProfileClient {

	@Override
	public ResponseEntity<Customer> findCustomerByUserNameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

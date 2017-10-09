package customer.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import customer.entity.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{
	Customer findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}

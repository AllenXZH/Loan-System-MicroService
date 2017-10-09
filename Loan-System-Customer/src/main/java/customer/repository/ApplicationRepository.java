package customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import customer.entity.Application;

public interface ApplicationRepository extends MongoRepository<Application, String>{
	
}

package official.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import official.entity.Application;

@RepositoryRestResource
public interface ApplicationRepository extends MongoRepository<Application, String>{
	
	Application findById(@Param("id") String id);
	
	Application findByPhone(@Param("phone") String phone);
	
	Application findBySsn(@Param("ssn") String ssn);
	

}

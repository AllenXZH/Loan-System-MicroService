package official.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import official.entity.Employee;

public interface EmplyeeRepository extends MongoRepository<Employee, String>{
	
	Employee findByIdAndPassword(@Param("id") String id, @Param("password") String password);
}

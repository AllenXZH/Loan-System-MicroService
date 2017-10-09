package CustomerProfile;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface ProfileRepository extends MongoRepository<Customer, String>{
	Customer findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}

package CustomerProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProfileService {
	
	@Autowired
	ProfileRepository profileRepository;
	
	public Customer findByUsernameAndPassword(String username, String password) {
		Customer customer;
		customer = profileRepository.findByUsernameAndPassword(username, password);
		
		if (customer == null) {
			return null;
		}
		
		return customer;
	}
}

package official.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import official.entity.Application;
import official.repositories.ApplicationRepository;

@Service
@Transactional
public class ApplicationService {
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	public String approve(int approve, String id) {
		Application application;
		application = applicationRepository.findById(id);
		if (application == null) {
			return "application not found";
		}
				
		if (approve == 1) {
			application.setApprove(true);
			applicationRepository.save(application);
			return "approved";
		} else {
			application.setApprove(false);
			applicationRepository.save(application);
			return "rejected";
		}
	}
}

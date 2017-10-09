package official.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import official.entity.Application;
import official.repositories.ApplicationRepository;
import official.service.ApplicationService;

@RestController
public class Controller {
	
	
	
	@Autowired
	ApplicationService applicationService;
	
	@HystrixCommand(fallbackMethod="defaultFallback")
	@RequestMapping(path="/application/{id}", method=RequestMethod.PUT) 
	public String approve(@RequestParam("approve") int approve, @PathVariable("id") String id) {
		if (approve != 1 && approve != 0 || id == null) {
			return "prameter missing";
		}
		
		return applicationService.approve(approve, id);
	}
	
	public String defaultFallback(int approve, String id) {
		return "service error";
	}

}

package customer.controller;

import java.lang.reflect.Method;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import customer.entity.Application;
import customer.repository.ApplicationRepository;

@RestController
public class ApplyController {
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	@RequestMapping(path="/apply", method=RequestMethod.POST) 
	public Object apply(@Valid Application application, BindingResult result){
		if (result.hasErrors()) {
			String message = "";
			for (FieldError error : result.getFieldErrors()) {
				message += error.getDefaultMessage();
			}
			return message;
		}
		applicationRepository.save(application);
		return application;
	}
	
	@RequestMapping(path="/apply2", method=RequestMethod.POST) 
	public Application apply(@Valid Application application){
		if (application == null) {
			return null;
		}
		applicationRepository.save(application);
		return application;
	}
	
	
	@RequestMapping(path="/apply3", method=RequestMethod.POST) 
	public String apply3(){
		return "apply3";
	}
}

package APIGateway.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import APIGateway.client.CustomerSystemClient;
import APIGateway.entity.Application;

@Controller
public class CustomerApplyController {
	
	@Autowired
	CustomerSystemClient customerSystemClient;
	
	@RequestMapping("/apply")
	public String apply(@Valid Application application, BindingResult result) {
		if (result.hasErrors()) {
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "invalid application";
		}
		
		Application newApplication;
		newApplication = customerSystemClient.apply(application);
		if (newApplication == null) {
			return "apply error";
		}
		return "success";
	}
}

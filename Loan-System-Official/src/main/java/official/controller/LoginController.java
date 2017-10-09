package official.controller;



import java.util.Collection;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import official.entity.Employee;
import official.repositories.ApplicationRepository;
import official.repositories.EmplyeeRepository;

@RestController
@SessionAttributes("officialId")
public class LoginController {
	
	@Autowired
	EmplyeeRepository employeeRepository;
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	
	
	@RequestMapping("/login")
	public String login(@RequestBody @Valid Employee employee, BindingResult result, ModelMap map) {
		//Error handle
		if (result.hasErrors()) {
			System.out.println("ERROR: ");
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + error.getDefaultMessage());
			}
			return "error";
		}
		if (employeeRepository.findByIdAndPassword(employee.getId(), employee.getPassword()) != null) {
			map.put("officialId", employee.getId());
			return "hello";		
		} else {
			return "login fail";
		}
	}
	
	@RequestMapping("/index")
	public String hello() {
		return "hello";
	}
	
	
	

}

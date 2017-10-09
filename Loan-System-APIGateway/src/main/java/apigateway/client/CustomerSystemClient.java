package apigateway.client;

import javax.validation.Valid;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import apigateway.entity.Application;


@FeignClient(value = "loan-customer-system", fallback = CustomerSystemClientFallback.class)
public interface CustomerSystemClient {
	
	@RequestMapping(path="/apply", method=RequestMethod.POST)
	Application apply(@Valid Application application);
}

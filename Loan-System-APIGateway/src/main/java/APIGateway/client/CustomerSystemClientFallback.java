package APIGateway.client;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import APIGateway.entity.Application;

@Component
public class CustomerSystemClientFallback implements CustomerSystemClient {

	@Override
	public Application apply(Application application) {
		// TODO Auto-generated method stub
		return null;
	}

}

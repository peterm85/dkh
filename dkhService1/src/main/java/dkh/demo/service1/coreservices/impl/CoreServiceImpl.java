package dkh.demo.service1.coreservices.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dkh.demo.service1.coreservices.CoreService;
import dkh.demo.service1.providers.DeclarativePersonProvider;
import dkh.demo.service1.providers.apimodel.PersonResponse;

@Service
public class CoreServiceImpl implements CoreService{

	@Autowired
	private DeclarativePersonProvider decService1Provider;
	
	@Value("${dkhservice1.showhostname}")
	private boolean showHostname;
	@Value("${dkhservice1.hostname}")
	private String hostname;
	
	
	@Override
	public String getMessage() {
		
		StringBuilder message= new StringBuilder();
		if(showHostname) {
			message.append(hostname);
			message.append(": ");
		}
		message.append("Hola ");
		message.append(getPerson().getName());
		
		return message.toString();
	}
	
	private PersonResponse getPerson() {
		try {
			return decService1Provider.getPerson();
		}catch(ResponseStatusException ex) {
			return PersonResponse.notFound();
		}
	}
}

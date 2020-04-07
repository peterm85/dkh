package dkh.demo.service1.coreservices.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import dkh.demo.service1.coreservices.CoreService;
import dkh.demo.service1.providers.Service1Provider;

@Service
public class CoreServiceImpl implements CoreService{

	@Autowired
	private Service1Provider service1Provider;
	
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
		message.append(service1Provider.getPerson().getName());
		
		return message.toString();
	}
}

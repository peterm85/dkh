package dkh.demo.service1.coreservices.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dkh.demo.service1.config.Properties;
import dkh.demo.service1.coreservices.CoreService;
import dkh.demo.service1.providers.Service1Provider;

@Service
public class CoreServiceImpl implements CoreService{

	@Autowired
	private Service1Provider service1Provider;
	
	@Autowired
	private Properties properties;
	
	@Override
	public String getMessage() {
		
		StringBuilder message= new StringBuilder();
		if(properties.showHostname()) {
			message.append(properties.getHostName());
			message.append(": ");
		}
		message.append("Hola ");
		message.append(service1Provider.getPerson().getName());
		
		return message.toString();
	}
}

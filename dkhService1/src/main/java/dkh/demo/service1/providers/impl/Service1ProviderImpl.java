package dkh.demo.service1.providers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import dkh.demo.service1.providers.Service1Provider;
import dkh.demo.service1.providers.data.PersonResponse;

@Component
public class Service1ProviderImpl implements Service1Provider{
	
	@Autowired
    private RestTemplate restTemplate;
	
	private static String service2Path = System.getenv("DKHSERVICE2_PATH");
	
	@Override
	public PersonResponse getPerson() {
		return restTemplate.getForEntity(service2Path.concat("/person"), PersonResponse.class)
						   .getBody();
	}

}
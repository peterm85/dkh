package dkh.demo.service1.providers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import dkh.demo.service1.providers.Service1Provider;
import dkh.demo.service1.providers.data.PersonResponse;

@Component
public class Service1ProviderImpl implements Service1Provider{
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Value("${dkhservice2.path}")
	private String path;
	
	@Override
	public PersonResponse getPerson() {
		return restTemplate.getForEntity(path.concat("/person/1"), PersonResponse.class)
						   .getBody();
	}

}
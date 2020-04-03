package dkh.demo.service1.coreservices.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dkh.demo.service1.coreservices.CoreService;
import dkh.demo.service1.providers.Service1Provider;

@Service
public class CoreServiceImpl implements CoreService{

	@Autowired
	private Service1Provider service1Provider;
	
	@Override
	public String getName() {
		return service1Provider.getPerson().getName();
	}
}

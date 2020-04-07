package dkh.demo.service2.coreservices.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dkh.demo.service2.coreservices.CoreService;
import dkh.demo.service2.repository.PersonRepository;
import dkh.demo.service2.repository.data.Person;

@Service
public class CoreServiceImpl implements CoreService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person getPersonById(Integer personId) {
		return personRepository.findById(personId).get();
	}
}

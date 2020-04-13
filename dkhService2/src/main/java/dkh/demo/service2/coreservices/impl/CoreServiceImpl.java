package dkh.demo.service2.coreservices.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dkh.demo.service2.coreservices.CoreService;
import dkh.demo.service2.repository.PersonRepository;
import dkh.demo.service2.repository.domain.Person;

@Service
public class CoreServiceImpl implements CoreService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person getPersonById(Integer personId) {
		return personRepository.findById(personId)
				               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
				            		                                          "PersonId = "+personId+" not found"));
	}

	@Override
	public List<Person> getAll() {
		List<Person> result = new ArrayList<>();
		personRepository.findAll().forEach(result::add);
		return result;
	}
}
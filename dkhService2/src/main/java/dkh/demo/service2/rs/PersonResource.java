package dkh.demo.service2.rs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dkh.demo.service2.apimodel.PersonResponse;
import dkh.demo.service2.apimodel.converter.PersonIntoPersonResponseConverter;
import dkh.demo.service2.coreservices.CoreService;

@RestController
@RequestMapping("/person")
public class PersonResource {
	
	@Autowired 
	private CoreService coreService;
	@Autowired 
	private PersonIntoPersonResponseConverter converter;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<PersonResponse> getName() {
		return converter.convert( coreService.getAll() );
	}
	
	@GetMapping("/{id}")
 	@ResponseStatus(HttpStatus.OK)
	public PersonResponse getNameById(@PathVariable Integer id) {
		return converter.convert( coreService.getPersonById(id) );
	}
}

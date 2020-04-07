package dkh.demo.service2.rs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<PersonResponse> getName() {
		return new ResponseEntity<>(new PersonResponse("Pedro","Rodriguez"), 
								    HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PersonResponse> getNameById(@PathVariable Integer id) {
		return new ResponseEntity<>(converter.convert(coreService.getPersonById(id)), 
								    HttpStatus.OK);
	}
}

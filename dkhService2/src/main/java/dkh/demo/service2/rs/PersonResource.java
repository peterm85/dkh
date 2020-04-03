package dkh.demo.service2.rs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dkh.demo.service2.apimodel.PersonResponse;

@RestController
@RequestMapping("/person")
public class PersonResource {
	
	@GetMapping
	public ResponseEntity<PersonResponse> getName() {
		return new ResponseEntity<>(new PersonResponse("Pedro","Rodriguez"), 
								    HttpStatus.OK);
	}
}

package dkh.demo.service1.rs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dkh.demo.service1.coreservices.CoreService;

@RestController
@RequestMapping("/hello")
public class HelloResource {

	@Autowired
	private CoreService coreservice;
	
	@GetMapping
	public ResponseEntity<String> greetings() {
		return new ResponseEntity<>("Hola "+coreservice.getName(), HttpStatus.OK);
	}
}

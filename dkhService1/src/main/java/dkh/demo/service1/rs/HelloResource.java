package dkh.demo.service1.rs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dkh.demo.service1.coreservices.CoreService;
import dkh.demo.service1.rs.apimodel.HelloResponse;
import dkh.demo.service1.rs.converters.StringIntoHelloResponseConverter;

@RestController
@RequestMapping("/hello")
public class HelloResource {
	
	@Autowired
	private CoreService coreservice;

	@GetMapping
	public ResponseEntity<HelloResponse> greetings() {
		return new ResponseEntity<>(StringIntoHelloResponseConverter.converter(coreservice.getMessage()), 
				                    HttpStatus.OK);
	}
}

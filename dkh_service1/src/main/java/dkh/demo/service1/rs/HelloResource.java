package dkh.demo.service1.rs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloResource {

	@GetMapping
	public ResponseEntity<String> isHealthy() {
		return new ResponseEntity<>("Hola mundo", HttpStatus.OK);
	}
}

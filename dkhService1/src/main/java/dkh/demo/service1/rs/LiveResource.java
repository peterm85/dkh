package dkh.demo.service1.rs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/live")
public class LiveResource {
	
	private boolean isHealthy=true;
	
	@GetMapping("/healthy")
	public ResponseEntity isHealthy() {
		if(isHealthy)
			return new ResponseEntity(HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/kill")
	public ResponseEntity kill() {
		isHealthy = false;
		return new ResponseEntity(HttpStatus.OK);
	}
}

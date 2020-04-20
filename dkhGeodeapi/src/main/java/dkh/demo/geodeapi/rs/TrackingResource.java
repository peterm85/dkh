package dkh.demo.geodeapi.rs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dkh.demo.geodeapi.coreservices.TrackingService;
import dkh.demo.geodeapi.model.Tracking;

@RestController
@RequestMapping("/api/tracking")
public class TrackingResource {
	
	@Autowired
	private TrackingService trackingService;
	
	@GetMapping(value = "/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
 	@ResponseStatus(HttpStatus.OK)
	public Tracking getNameById(@PathVariable Integer personId) {
		return trackingService.get(personId);
	}
	
	@PostMapping(value = "/{personId}")
 	@ResponseStatus(HttpStatus.OK)
	public void register(@PathVariable Integer personId) {
		trackingService.register(personId);
	}
}

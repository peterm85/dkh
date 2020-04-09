package dkh.demo.service1.providers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import dkh.demo.service1.providers.apimodel.PersonResponse;

@FeignClient(name = "persons", url = "${dkhservice2.path}")
public interface DeclarativePersonProvider {
	
	@GetMapping(value = "/person/1")
	PersonResponse getPerson();
}

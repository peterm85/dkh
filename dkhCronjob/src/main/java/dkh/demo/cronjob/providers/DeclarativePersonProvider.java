package dkh.demo.cronjob.providers;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import dkh.demo.cronjob.providers.apimodel.PersonResponse;

@FeignClient(name = "persons", url = "${dkhservice2.path}")
public interface DeclarativePersonProvider {
	
	@GetMapping(value = "/person")
	List<PersonResponse> getAll();
}

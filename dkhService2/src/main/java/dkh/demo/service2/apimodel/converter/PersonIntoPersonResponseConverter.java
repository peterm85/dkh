package dkh.demo.service2.apimodel.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import dkh.demo.service2.apimodel.PersonResponse;
import dkh.demo.service2.repository.domain.Person;

@Component
public class PersonIntoPersonResponseConverter {
	
	public PersonResponse convert (Person person) {
		return new PersonResponse(person.getName(), person.getSurname());
	}
	
	public List<PersonResponse> convert (List<Person> persons){
		return persons.stream().map(p -> convert(p) )
							   .collect( Collectors.toList() );
	}
}

package dkh.demo.service2.apimodel.converter;

import org.springframework.stereotype.Component;

import dkh.demo.service2.apimodel.PersonResponse;
import dkh.demo.service2.repository.data.Person;

@Component
public class PersonIntoPersonResponseConverter {
	public PersonResponse convert (Person person) {
		return new PersonResponse(person.getName(), person.getSurname());
	}
}

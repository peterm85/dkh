package dkh.demo.service2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import dkh.demo.service2.repository.domain.Person;

@Component
public interface PersonRepository extends CrudRepository<Person, Integer>{

}

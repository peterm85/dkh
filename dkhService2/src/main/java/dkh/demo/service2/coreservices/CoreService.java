package dkh.demo.service2.coreservices;

import dkh.demo.service2.repository.data.Person;

public interface CoreService {
	Person getPersonById(Integer personId);
}

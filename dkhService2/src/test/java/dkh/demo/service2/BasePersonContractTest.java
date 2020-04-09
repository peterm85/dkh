package dkh.demo.service2;

import static org.mockito.Mockito.when;

import java.util.Optional;

import static dkh.demo.service2.repository.domain.Person.PersonBuilder;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import dkh.demo.service2.repository.PersonRepository;
import dkh.demo.service2.repository.domain.Person;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public abstract class BasePersonContractTest {
	 
    @Autowired
    WebApplicationContext context;
    @MockBean
    PersonRepository repository;
     
    @Before
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(this.context);
        Person mockedPerson = new PersonBuilder(1)
            .withName("Juan")
            .withSurname("Rodriguez")
            .withAge(35)
            .build();
        when(repository.findById(1)).thenReturn( Optional.of(mockedPerson) );
    }
}

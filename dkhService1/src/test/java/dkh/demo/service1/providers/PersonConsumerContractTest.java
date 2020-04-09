package dkh.demo.service1.providers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import dkh.demo.service1.providers.apimodel.PersonResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"dkh.demo.dkhService:dkhservice2:+:stubs:8081"}, //groupId:artifactId:+:stubs:listeningPort
						 stubsMode = StubRunnerProperties.StubsMode.LOCAL)
@DirtiesContext
public class PersonConsumerContractTest {
 
    @Autowired
    private PersonProvider personClient;
     
    @Test
    public void verifyPerson() {
        PersonResponse p = personClient.getPerson();
        Assert.assertNotNull(p);
        Assert.assertNotNull(p.getName());
        Assert.assertNotNull(p.getSurname());
     }
     
}

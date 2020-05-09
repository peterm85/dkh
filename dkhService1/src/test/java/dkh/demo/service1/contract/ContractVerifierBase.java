package dkh.demo.service1.contract;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import dkh.demo.service1.providers.DeclarativePersonProvider;
import dkh.demo.service1.providers.apimodel.PersonResponse;
import dkh.demo.service1.rs.HelloResource;
import dkh.demo.service1.rs.LiveResource;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, 
                properties = {"dkhservice1.showhostname=false"})
public class ContractVerifierBase {

	@MockBean protected DeclarativePersonProvider provider;
	@Autowired protected HelloResource helloController;
	@Autowired protected LiveResource liveController;
	
	@Before
    public void setup() {
		configureMocks();
		final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(helloController,
				                                                liveController)
											   .build();
		
    	RestAssuredMockMvc.mockMvc(mockMvc);
    }
	
	public void configureMocks() {
		when(provider.getPerson()).thenReturn(new PersonResponse("Juan","Rodriguez"));
	}
}

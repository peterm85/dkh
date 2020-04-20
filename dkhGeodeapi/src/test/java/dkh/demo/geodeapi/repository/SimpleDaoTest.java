package dkh.demo.geodeapi.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

import dkh.demo.geodeapi.config.GeodeConfig;

@TestPropertySource("classpath:application.yml")
@Import(GeodeConfig.class)
@SpringBootTest
public class SimpleDaoTest {
	
	@Autowired
	private SimpleDao simpleDao;
	
	@Test
	public void whenSendMessageToRegion_thenMessageSavedSuccessfully() {
		//when
		simpleDao.create("C", "example");
		//then
	    assertEquals("example", simpleDao.get("C"));
	}
}

package dkh.demo.geodeapi.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

import dkh.demo.geodeapi.config.GeodeConfig;
import dkh.demo.geodeapi.model.Tracking;

@TestPropertySource("classpath:application.yml")
@Import(GeodeConfig.class)
@SpringBootTest
public class TrackingDaoTest {
	
	@Autowired
	private TrackingDao trackingDao;
	
	private final Integer ID = 1;
	
	@Test
	public void whenSendMessageToRegion_thenMessageSavedSuccessfully() {
		//given
		Tracking t = new Tracking(ID);
		t.add(new Date());
		//when
		trackingDao.createOrUpdate(t);
		//then
		Tracking returned = trackingDao.get(ID).get();
		System.out.println(returned.getLogs());
	    assertEquals(1, returned.getLogs().size());
	}
	
	@Test
	public void whenUpdateMessageToRegion_thenMessageSavedSuccessfully() {
		//given
		Tracking given = trackingDao.get(ID).get();
		given.add(new Date());
		//when
		trackingDao.createOrUpdate(given);
		//then
		Tracking returned = trackingDao.get(ID).get();
		System.out.println(returned.getLogs());
	    assertEquals(2, returned.getLogs().size());
	}
}

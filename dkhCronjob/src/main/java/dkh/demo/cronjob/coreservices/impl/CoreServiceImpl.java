package dkh.demo.cronjob.coreservices.impl;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dkh.demo.cronjob.coreservices.CoreService;
import dkh.demo.cronjob.providers.DeclarativePersonProvider;

@Service
public class CoreServiceImpl implements CoreService{

	@Autowired
	private DeclarativePersonProvider personProvider;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CoreServiceImpl.class);
	
	public void batch() throws InterruptedException {
		
		try {
			
			LOGGER.info("######### Listado de personas ########");
			LOGGER.info(personProvider.getAll().toString());
			LOGGER.info("######################################");
			
		}catch(Exception ex) {
			
			LOGGER.error("Provider Connection refused", ex);
			TimeUnit.SECONDS.sleep(1);
			batch();
		}
	}
}

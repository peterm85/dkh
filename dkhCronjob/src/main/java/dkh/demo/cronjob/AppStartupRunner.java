package dkh.demo.cronjob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import dkh.demo.cronjob.coreservices.CoreService;

@Component
public class AppStartupRunner implements ApplicationRunner {
    
	@Autowired
	private CoreService coreService;
	
    @Override
    public void run(ApplicationArguments args) throws Exception {
        coreService.batch();
    }
}

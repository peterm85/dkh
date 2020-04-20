package dkh.demo.geodeapi.coreservices.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dkh.demo.geodeapi.coreservices.TrackingService;
import dkh.demo.geodeapi.model.Tracking;
import dkh.demo.geodeapi.repository.TrackingDao;

@Service
public class TrackingServiceImpl implements TrackingService{
	
	@Autowired
	private TrackingDao trackingDao;

	@Override
	public Tracking get(Integer personId) {
		return trackingDao.get(personId)
                          .orElse(new Tracking(personId));
	}
	
	@Override
	public void register(Integer personId) {
		trackingDao.get(personId)
                   .ifPresentOrElse( t -> save(t),
                		   			() -> save(new Tracking(personId))
                   );
	}
	
	private void save(Tracking t) {
		t.add(new Date());
  	    trackingDao.createOrUpdate(t);
	}
}

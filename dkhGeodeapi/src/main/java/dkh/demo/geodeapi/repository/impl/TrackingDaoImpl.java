package dkh.demo.geodeapi.repository.impl;

import java.util.Optional;

import org.apache.geode.cache.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dkh.demo.geodeapi.model.Tracking;
import dkh.demo.geodeapi.repository.TrackingDao;

@Repository
public class TrackingDaoImpl implements TrackingDao{

	@Autowired
	private Region<Integer,Tracking> trackingRegion;
	
	@Override
	public Optional<Tracking> get(int id) {
		return Optional.ofNullable(this.trackingRegion.get(id));
	}

	@Override
	public void createOrUpdate(Tracking t) {
		this.trackingRegion.put(t.getPersonId(), t);
	}
}

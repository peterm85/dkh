package dkh.demo.geodeapi.repository;

import java.util.Optional;

import dkh.demo.geodeapi.model.Tracking;

public interface TrackingDao {
	Optional<Tracking> get(int id);
	void createOrUpdate(Tracking t);
}

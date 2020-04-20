package dkh.demo.geodeapi.coreservices;

import dkh.demo.geodeapi.model.Tracking;

public interface TrackingService {
	Tracking get(Integer personId);
	void register(Integer personId);
}

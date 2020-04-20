package dkh.demo.geodeapi.repository.impl;

import org.apache.geode.cache.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dkh.demo.geodeapi.repository.SimpleDao;

@Repository
public class SimpleDaoImpl implements SimpleDao{

	@Autowired
	private Region<String,String> dkhRegion;
	
	@Override
	public String get(String key) {
		return dkhRegion.get(key);
	}
	
	@Override
	public void create(String key, String value) {
		this.dkhRegion.put(key, value);
	}
}

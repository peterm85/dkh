package dkh.demo.geodeapi.config;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dkh.demo.geodeapi.model.Tracking;

@Configuration
public class GeodeConfig {

	private ClientCache cache;
	private Region<String,String> dkhRegion;
	private Region<Integer,Tracking> trackingRegion;
	
	public GeodeConfig(@Value("${geodeserver.host}") String geodeServerHost,
			           @Value("${geodeserver.port}") Integer geodeServerPort) {
		
		final ClientCacheFactory cf = new ClientCacheFactory().addPoolServer(geodeServerHost, geodeServerPort);
	    this.cache = cf.setPdxReadSerialized(true).create();
	    final ClientRegionFactory crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
	    
	    this.dkhRegion = crf.create("dkh");
	    this.trackingRegion = crf.create("tracking");
	}
	
	@Bean
	public ClientCache cache() {
		return cache;
	}
	
	@Bean
	public Region<String,String> dkhRegion(){
	    return dkhRegion; 
	}

	@Bean
	public Region<Integer,Tracking> trackingRegion(){
	    return trackingRegion; 
	}
}
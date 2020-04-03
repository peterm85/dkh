package dkh.demo.service1.config;

import org.springframework.stereotype.Component;

@Component
public class Properties {
	
	private String dkhService2Url;
	private String hostName;
	private boolean showHostname;
	
	public Properties() {
		super();
		dkhService2Url = System.getenv("DKHSERVICE2_PATH");
		hostName = System.getenv("HOSTNAME");
		showHostname = System.getenv("showHostname").equals("true");
	}

	public String getDkhService2Url() {
		return dkhService2Url;
	}

	public String getHostName() {
		return hostName;
	}

	public boolean showHostname() {
		return showHostname;
	}
}

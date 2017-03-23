package hu.inno.demo.ws.impl;

import org.springframework.stereotype.Service;

@Service
public class VersionInfo {
	public String getAppName() {
		return "CXF teszt";
	}

	public String getVersion() {
		return "v1.0.0";
	}
}

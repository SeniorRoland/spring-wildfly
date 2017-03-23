package hu.inno.demo.ws.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "app-info")
@XmlType(name = "app-info-type")
@XmlAccessorType(value = XmlAccessType.FIELD)
/**
 * Alkalmazás információ
 * 
 * @author Csuhai Roland
 *
 */
public class ApplicationInfo {
	@XmlElement(name = "app-name")
	private String appName;

	@XmlElement(name = "app-version")
	private String appVersion;

	/**
	 * Alklamazás neve
	 * 
	 * @return
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * Alkalmazás neve
	 * 
	 * @param appName
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
	 * Alkalmazás verziószáma
	 * 
	 * @return
	 */
	public String getAppVersion() {
		return appVersion;
	}

	/**
	 * Alkalmazás verziószáma
	 * 
	 * @param appVersion
	 */
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	@Override
	public String toString() {
		return new StringBuilder("Alkalmazás: ").append(getAppName()).append("\n").append("Version: ")
				.append(getAppVersion()).toString();
	}
}

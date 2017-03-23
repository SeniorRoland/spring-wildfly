package hu.inno.demo.ws.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "app-info-request")
@XmlType(name = "app-info-request-type")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ApplicationInfoRequest {

	protected String parameter;

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

}

package hu.inno.demo.ws.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(propOrder = { "serviceConsumer", "serviceConsumerQualifier", "ignoreWarnings", "messageId", "refererMessageId",
		"parameterList" })
public class CallContext {

	protected String serviceConsumer;
	protected String serviceConsumerQualifier;
	protected String ignoreWarnings;
	protected String messageId;
	protected String refererMessageId;
	protected List<ParameterElement> parameterList;

	public String getServiceConsumer() {
		return serviceConsumer;
	}

	public void setServiceConsumer(String serviceConsumer) {
		this.serviceConsumer = serviceConsumer;
	}

	public String getServiceConsumerQualifier() {
		return serviceConsumerQualifier;
	}

	public void setServiceConsumerQualifier(String serviceConsumerQualifier) {
		this.serviceConsumerQualifier = serviceConsumerQualifier;
	}

	public String getIgnoreWarnings() {
		return ignoreWarnings;
	}

	public void setIgnoreWarnings(String ignoreWarnings) {
		this.ignoreWarnings = ignoreWarnings;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getRefererMessageId() {
		return refererMessageId;
	}

	public void setRefererMessageId(String refererMessageId) {
		this.refererMessageId = refererMessageId;
	}

	public List<ParameterElement> getParameterList() {
		return parameterList;
	}

	public void setParameterList(List<ParameterElement> parameterList) {
		this.parameterList = parameterList;
	}

}

package hu.inno.demo.ws.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import hu.inno.demo.stat.Severity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "correlationId", "highestMessageSeverity", "messageList" })
public class ResultContext {

	protected String correlationId;
	protected String highestMessageSeverity;
	protected List<ResultMessage> messageList;

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public String getHighestMessageSeverity() {
		return highestMessageSeverity;
	}

	public void setHighestMessageSeverity(String highestMessageSeverity) {
		this.highestMessageSeverity = highestMessageSeverity;
	}

	public List<ResultMessage> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<ResultMessage> messageList) {
		this.messageList = messageList;
	}

	public static void setHighestSeverity(ResultContext resultContext) {
		Severity severity = null;

		for (ResultMessage resultMessage : resultContext.getMessageList()) {
			if (resultMessage.getSeverity() == null) {
				continue;
			}
			if (severity == null) {
				severity = Severity.getSeverity(resultMessage.getSeverity());
				continue;
			}

			Severity current = Severity.getSeverity(resultMessage.getSeverity());
			if (current.ordinal() > severity.ordinal()) {
				severity = current;
			}
		}

		resultContext.setHighestMessageSeverity(severity != null ? severity.getSeverity() : null);
	}

	public static void addErrorMessages(List<ResultMessage> errorMessages, List<String> messages) {
		for (String message : messages) {
			errorMessages.add(new ResultMessage("9102", "E", "SYS", message));
		}
	}

	public static void addWarnMessages(List<ResultMessage> errorMessages, List<String> messages) {
		for (String message : messages) {
			errorMessages.add(new ResultMessage("9102", "W", "SYS", message));
		}
	}

	public static void addInfoMessages(List<ResultMessage> errorMessages, List<String> messages) {
		for (String message : messages) {
			errorMessages.add(new ResultMessage("INFO", "I", "SYS", message));
		}
	}
}

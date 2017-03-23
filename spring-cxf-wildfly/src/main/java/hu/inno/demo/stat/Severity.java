package hu.inno.demo.stat;

public enum Severity {
	INFO("I", "Info"), WARN("W", "Warn"), ERROR("E", "Error");

	private String sev;
	private String title;

	private Severity(String severity, String title) {
		this.sev = severity;
		this.title = title;
	}

	@Override
	public String toString() {
		return getTitle();
	}

	public static Severity getSeverity(String strSeverity) {
		if ("E".equalsIgnoreCase(strSeverity)) {
			return Severity.ERROR;
		} else if ("W".equalsIgnoreCase(strSeverity)) {
			return Severity.WARN;
		} else if ("I".equalsIgnoreCase(strSeverity)) {
			return Severity.INFO;
		}
		return null;
	}

	public String getSeverity() {
		return sev;
	}

	public String getTitle() {
		return title;
	}
}

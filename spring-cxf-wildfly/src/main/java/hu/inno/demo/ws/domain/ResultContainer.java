package hu.inno.demo.ws.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlSeeAlso(value = { Date.class })
public abstract class ResultContainer<T> {

	protected ResultContext resultContext;

	private static ThreadLocal<ResultContainer<?>> resultContainer = new ThreadLocal<ResultContainer<?>>();

	public static ResultContainer<?> getResultContainer() {
		return resultContainer.get();
	}

	public static void setResultContainer(ResultContainer<?> container) {
		resultContainer.set(container);
	}

	public ResultContainer() {
		this.resultContext = new ResultContext();
	}

	public ResultContainer(T result) {
		this.setResult(result);
		this.resultContext = new ResultContext();
	}

	public ResultContainer(T result, ResultContext resultContext) {
		this.setResult(result);
		this.resultContext = resultContext;
	}

	public abstract void clearResult();

	public abstract T getResult();

	public abstract void setResult(T result);

	public ResultContext getResultContext() {
		return resultContext;
	}

	public void setResultContext(ResultContext resultContext) {
		this.resultContext = resultContext;
	}

}

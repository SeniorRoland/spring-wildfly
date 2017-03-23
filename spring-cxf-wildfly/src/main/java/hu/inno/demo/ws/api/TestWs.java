package hu.inno.demo.ws.api;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import hu.inno.demo.ws.domain.ApplicationInfoRequest;
import hu.inno.demo.ws.domain.ApplicationInfoResultContainer;
import hu.inno.demo.ws.domain.CallContext;

@SOAPBinding(style = Style.DOCUMENT, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
@WebService(name = "TestWs", targetNamespace = "http://test.ns/")
public interface TestWs {
	@ResponseWrapper(localName = "response-get-app-info", targetNamespace = "http://test.ns/")
	@RequestWrapper(localName = "request-get-app-info", targetNamespace = "http://test.ns/")
	@WebMethod(operationName = "op-get-app-info")
	@WebResult(name = "get-app-info-result")
	public abstract ApplicationInfoResultContainer test(@WebParam(name = "callContext") CallContext callContext,
			@WebParam(name = "request") ApplicationInfoRequest appInfoRequest);
}

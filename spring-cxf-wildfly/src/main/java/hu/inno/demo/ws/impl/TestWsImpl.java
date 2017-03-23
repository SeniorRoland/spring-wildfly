package hu.inno.demo.ws.impl;

import java.util.ArrayList;

import javax.jws.WebService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import hu.inno.demo.ws.api.TestWs;
import hu.inno.demo.ws.domain.ApplicationInfo;
import hu.inno.demo.ws.domain.ApplicationInfoRequest;
import hu.inno.demo.ws.domain.ApplicationInfoResultContainer;
import hu.inno.demo.ws.domain.CallContext;
import hu.inno.demo.ws.domain.ResultContext;
import hu.inno.demo.ws.domain.ResultMessage;

@WebService(name = "ApplicationInfoService", serviceName = "ApplicationInfoService", portName = "ApplicationInfoServicePort", endpointInterface = "hu.inno.demo.ws.api.TestWs", targetNamespace = "http://test.ns/")
@Transactional
public class TestWsImpl implements TestWs {
	@SuppressWarnings("unused")
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestWsImpl.class);

	@Autowired
	private VersionInfo versionInfo;

	public ApplicationInfoResultContainer test(CallContext callContext, ApplicationInfoRequest appInfoRequest) {
		ApplicationInfo result = new ApplicationInfo();
		result.setAppName(versionInfo.getAppName());
		result.setAppVersion(versionInfo.getVersion());

		ResultContext resultContext = new ResultContext();
		resultContext.setCorrelationId("corrId");
		resultContext.setHighestMessageSeverity("W");
		resultContext.setMessageList(new ArrayList<ResultMessage>());
		resultContext.getMessageList().add(new ResultMessage("code", "sev", "system", "message"));

		return new ApplicationInfoResultContainer(result, resultContext);
	}
}

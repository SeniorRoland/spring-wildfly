package hu.inno.demo.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hu.inno.demo.ws.api.ApplicationInfoService;
import hu.inno.demo.ws.impl.ApplicationInfoServiceImpl;

@Configuration
public class WebServiceConfig {

	@Bean
	public ServletRegistrationBean cxfDispatcherServlet() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new CXFServlet(), "/soap/*");
		registrationBean.setAsyncSupported(true);
		registrationBean.setLoadOnStartup(3);
		registrationBean.setName("CXFServlet");
		return registrationBean;
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	@Autowired
	public SpringBus springBus(LoggingInInterceptor loggingInInterceptor, LoggingOutInterceptor loggingOutInterceptor) {
		SpringBus bus = new SpringBus();
		bus.getInInterceptors().add(loggingInInterceptor);
		bus.getInFaultInterceptors().add(loggingInInterceptor);
		bus.getOutInterceptors().add(loggingOutInterceptor);
		bus.getOutFaultInterceptors().add(loggingOutInterceptor);

		return bus;
	}

	@Bean
	public ApplicationInfoService applicationInfoWS() {
		return new ApplicationInfoServiceImpl();
	}

	@Bean
	@Autowired
	public Endpoint applicationInfo(SpringBus springBus) {
		EndpointImpl endpoint = new EndpointImpl(springBus, applicationInfoWS());
		endpoint.publish("/ApplicationInfo");

		return endpoint;
	}

	@Bean
	public LoggingInInterceptor loggingInInterceptor() {
		return new LoggingInInterceptor();
	}

	@Bean
	public LoggingOutInterceptor loggingOutInterceptor() {
		LoggingOutInterceptor loggingOutInterceptor = new LoggingOutInterceptor();
		loggingOutInterceptor.setShowBinaryContent(false);
		loggingOutInterceptor.setShowMultipartContent(false);

		return loggingOutInterceptor;
	}

}
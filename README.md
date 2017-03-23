# Wildfly 10.x - Spring 4.x - CXF JAX-WS sample applications.

Need to edit or create some existing WildFly modul configuration.

### 1. Create org.springframework.spring module

This configuration contains more Spring dependency. You can narrow the list.

<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.3" name="org.springframework.spring">

    <resources>
      <resource-root path="spring-aop-4.3.7.RELEASE.jar"/>
      <resource-root path="spring-beans-4.3.7.RELEASE.jar"/>
      <resource-root path="spring-context-4.3.7.RELEASE.jar"/>
      <resource-root path="spring-context-support-4.3.7.RELEASE.jar"/>
      <resource-root path="spring-core-4.3.7.RELEASE.jar"/>
      <resource-root path="spring-data-commons-1.13.1.RELEASE.jar"/>
      <resource-root path="spring-data-jpa-1.11.1.RELEASE.jar"/>
      <resource-root path="spring-expression-4.3.7.RELEASE.jar"/>
      <resource-root path="spring-instrument-4.3.7.RELEASE.jar"/>
      <resource-root path="spring-jdbc-4.3.7.RELEASE.jar"/>
      <resource-root path="spring-orm-4.3.7.RELEASE.jar"/>
      <resource-root path="spring-security-config-4.2.2.RELEASE.jar"/>
      <resource-root path="spring-security-core-4.2.2.RELEASE.jar"/>
      <resource-root path="spring-security-web-4.2.2.RELEASE.jar"/>
      <resource-root path="spring-security-ldap-4.2.2.RELEASE.jar"/>
      <resource-root path="spring-tx-4.3.7.RELEASE.jar"/>
      <resource-root path="spring-web-4.3.7.RELEASE.jar"/>
      <resource-root path="spring-webmvc-4.3.7.RELEASE.jar"/>
      <resource-root path="spring-ldap-core-2.2.0.RELEASE.jar"/>
      <resource-root path="c3p0-0.9.1.1.jar"/>
      <resource-root path="quartz-2.2.3.jar"/>
      <resource-root path="spring-jms-4.2.8.RELEASE.jar"/>
      <resource-root path="commons-fileupload-1.3.2.jar"/>
      <resource-root path="commons-io-2.2.jar"/>
      <resource-root path="aspectjrt-1.7.1.jar"/>
      <resource-root path="aspectjweaver-1.7.1.jar"/>
      <resource-root path="aopalliance-1.0.jar"/>
    </resources>

    <dependencies>
      <module name="sun.jdk" />
      <module name="org.slf4j"/>
      <module name="javax.api"/>
      <module name="javax.persistence.api"/>
      <module name="javax.servlet.api"/>
      <module name="javax.servlet.jsp.api"/>
      <module name="javax.jms.api"/>
      <module name="javax.annotation.api"/>
      <module name="org.apache.commons.logging"/>
      <module name="org.apache.commons.lang"/>
      <module name="org.jboss.vfs"/>
      <module name="com.fasterxml.jackson.core.jackson-core" />
      <module name="com.fasterxml.jackson.core.jackson-databind" />
      <module name="com.fasterxml.jackson.core.jackson-annotations"/>
    </dependencies>
</module>


### 2. Edit ..\org\apache\cxf\main\module.xml

<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.3" name="org.apache.cxf">

    <resources>
        <resource-root path="cxf-core-3.1.6.jar"/>
    </resources>

    <dependencies>
        <module name="org.apache.cxf.impl" services="import">
            <imports>
                <include path="META-INF/cxf"/> <!-- required to also pull in the bus extensions from META-INF -->
                <include path="META-INF"/>
            </imports>
        </module>
        <module name="asm.asm" />
        <module name="javax.api" />
        <module name="javax.annotation.api" />
        <module name="javax.validation.api" optional="true"/>
        <module name="javax.jws.api" />
        <module name="javax.mail.api" />
        <module name="javax.resource.api" />
        <module name="javax.wsdl4j.api" />
        <module name="javax.xml.bind.api" services="import"/>
        <module name="com.sun.xml.bind" services="import"/>
        <module name="javax.xml.soap.api" />
        <module name="javax.xml.stream.api" />
        <module name="javax.xml.ws.api" />
        <module name="com.sun.xml.fastinfoset"/>
        <module name="org.apache.neethi" />
        <module name="org.apache.ws.xmlschema" />
        <module name="org.codehaus.woodstox" />
        <module name="org.apache.xml-resolver" />
        <module name="org.springframework.spring" optional="true">
            <imports>
                <include path="META-INF"/>
            </imports>
        </module>
    </dependencies>
</module>


### 3. Edit ..\org\apache\cxf\impl\main\module.xml

<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.3" name="org.apache.cxf.impl">

    <properties>
        <property name="jboss.api" value="private"/>
    </properties>

    <resources>
        <resource-root path="cxf-rt-bindings-coloc-3.1.6.jar"/>
        <resource-root path="cxf-rt-bindings-object-3.1.6.jar"/>
        <resource-root path="cxf-rt-bindings-soap-3.1.6.jar"/>
        <resource-root path="cxf-rt-bindings-xml-3.1.6.jar"/>
        <resource-root path="cxf-rt-databinding-aegis-3.1.6.jar"/>
        <resource-root path="cxf-rt-databinding-jaxb-3.1.6.jar"/>
        <resource-root path="cxf-rt-features-clustering-3.1.6.jar"/>
        <resource-root path="cxf-rt-frontend-jaxws-3.1.6.jar"/>
        <resource-root path="cxf-rt-frontend-simple-3.1.6.jar"/>
        <resource-root path="cxf-rt-management-3.1.6.jar"/>
        <resource-root path="cxf-rt-security-3.1.6.jar"/>
        <resource-root path="cxf-rt-security-3.1.6-jandex.jar"/>
        <resource-root path="cxf-rt-security-saml-3.1.6.jar"/>
        <resource-root path="cxf-rt-transports-http-3.1.6.jar"/>
        <resource-root path="cxf-rt-transports-http-hc-3.1.6.jar"/>
        <resource-root path="cxf-rt-transports-jms-3.1.6.jar"/>
        <resource-root path="cxf-rt-transports-local-3.1.6.jar"/>
        <resource-root path="cxf-rt-wsdl-3.1.6.jar"/>
        <resource-root path="cxf-rt-ws-addr-3.1.6.jar"/>
        <resource-root path="cxf-rt-ws-mex-3.1.6.jar"/>
        <resource-root path="cxf-rt-ws-policy-3.1.6.jar"/>
        <resource-root path="cxf-rt-ws-rm-3.1.6.jar"/>
        <resource-root path="cxf-tools-common-3.1.6.jar"/>
        <resource-root path="cxf-tools-java2ws-3.1.6.jar"/>
        <resource-root path="cxf-tools-validator-3.1.6.jar"/>
        <resource-root path="cxf-tools-wsdlto-core-3.1.6.jar"/>
        <resource-root path="cxf-tools-wsdlto-databinding-jaxb-3.1.6.jar"/>
        <resource-root path="cxf-tools-wsdlto-frontend-jaxws-3.1.6.jar"/>
        <resource-root path="cxf-services-ws-discovery-api-3.1.6.jar"/>
        <resource-root path="cxf-xjc-boolean-3.0.5.jar"/>
        <resource-root path="cxf-xjc-bug986-3.0.5.jar"/>
        <resource-root path="cxf-xjc-dv-3.0.5.jar"/>
        <resource-root path="cxf-xjc-ts-3.0.5.jar"/>
        <resource-root path="cxf-xjc-runtime-3.0.5.jar"/>
    </resources>

    <dependencies>
        <module name="asm.asm" />
        <module name="javax.api" />
        <module name="javax.annotation.api" />
        <module name="javax.jms.api" />
        <module name="javax.jws.api" />
        <module name="javax.mail.api" />
        <module name="javax.resource.api" />
        <module name="javax.servlet.api" />
        <module name="javax.wsdl4j.api" />
        <module name="javax.xml.bind.api" services="import"/>
        <module name="com.sun.xml.bind" services="import"/>
        <module name="javax.xml.soap.api" />
        <module name="javax.xml.stream.api" />
        <module name="javax.xml.ws.api" />
        <module name="org.apache.commons.lang" />
        <module name="org.apache.httpcomponents"/>
        <module name="org.apache.neethi" />
        <module name="org.apache.velocity" />
        <module name="org.apache.xml-resolver" />
        <module name="org.apache.ws.xmlschema" />
        <module name="org.apache.ws.security" />
        <module name="org.apache.santuario.xmlsec" />
        <module name="org.codehaus.woodstox" />
        <module name="org.joda.time" />
        <module name="org.opensaml" />
        <module name="org.apache.cxf" export="true">
          <imports>
            <include path="META-INF/cxf"/>
            <include path="META-INF"/>
          </imports>
          <exports>
            <include path="META-INF/cxf"/>
            <include path="META-INF"/>
          </exports>
        </module>
        <module name="org.apache.cxf.ws-security" export="true" services="export">
          <imports>
            <include path="META-INF/cxf"/>
            <include path="META-INF"/>
          </imports>
          <exports>
            <include path="META-INF/cxf"/>
            <include path="META-INF"/>
          </exports>
        </module>
        <module name="org.apache.cxf.services-sts" export="true" services="export">
          <imports>
            <include path="META-INF/cxf"/>
            <include path="META-INF"/>
          </imports>
          <exports>
            <include path="META-INF/cxf"/>
            <include path="META-INF"/>
          </exports>
        </module>
        <module name="org.springframework.spring" export="true" services="export" />
    </dependencies>
</module>

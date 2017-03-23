/**
 * 
 */
package hu.inno.demo.ws.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <callContext>
 * <!-- A szolgáltatást hívó rendszer azonosítója -->
 * <serviceConsumer>TIR</serviceConsumer>
 * <!-- A szolgáltatást hívó rendszeren belüli minősítő -->
 * <serviceConsumerQualifier>my_web_userid</serviceConsumerQualifier>
 * <!-- A végrehajtás megszakítása / folytatása figyelmeztetés esetén -->
 * <ignoreWarnings>1</ignoreWarnings>
 * <!-- Egyedi hívás azonosító -->
 * <!--Optional:-->
 * <messageId>c102bfaf-5bd5-4812-a9b5-5833b76f0679</messageId>
 * <!-- A hívást kezdeményező hívás azonosítója -->
 * <!--Optional:-->
 * <refererMessageId>308c77d7-5e49-4d68-ba53-081b2f044544</refererMessageId>
 * <!-- A szolgáltatáshívás egyedi opcionális paramétereit tartalmazó lista -->
 * <!--Zero or more repetitions:-->
 * <parameterList>
 * <!--Optional:-->
 * <key>custom_technical_parameter</key>
 * <!--Optional:-->
 * <value>custom_technical_value</value>
 * </parameterList>
 * </callContext>
 * 
 * @author pbrindzik
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(propOrder = { "serviceConsumer", "serviceConsumerQualifier", "ignoreWarnings", "messageId", "refererMessageId", "parameterList" })
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

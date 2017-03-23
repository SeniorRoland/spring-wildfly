/**
 * 
 */
package hu.inno.demo.ws.domain;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <resultContext>
 * <!-- Egyedi hívásazonosító -->
 * <correlationId>9f9ece62-75c8-11e2-b729-c13d1d06ef8f</correlationId>
 * <!-- A hívás kiszolgálása során fellépett legsúlyosabb hiba -->
 * <highestMessageSeverity>E</highestMessageSeverity>
 * <!-- A hívás kiszolgálása során keletkezett hibaüzenetek listája -->
 * <messageList>
 * <code>ERROR</code>
 * <severity>E</severity>
 * <sourceSystemCode>MY_DB_1</sourceSystemCode>
 * <text>Hiba szöveg 1 ...</text>
 * </messageList>
 * <messageList>
 * <code>ERROR</code>
 * <severity>E</severity>
 * <sourceSystemCode>MY_OS</sourceSystemCode>
 * <text>Hiba szöveg 1 ...</text>
 * </messageList>
 * </resultContext>
 * 
 * @author pbrindzik
 */
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
      String[] severities = new String[] { "I", "W", "E" };
      String severity = null;
      for (ResultMessage resultMessage : resultContext.getMessageList()) {
         if (resultMessage.getSeverity() == null) {
            continue;
         }
         if (severity == null) {
            severity = resultMessage.getSeverity();
            continue;
         }

         int index = Arrays.binarySearch(severities, resultMessage.getSeverity());
         if (index > Arrays.binarySearch(severities, severity)) {
            severity = resultMessage.getSeverity();
         }
      }

      resultContext.setHighestMessageSeverity(severity);
   }

   public static void addErrorMessages(List<ResultMessage> errorMessages, List<String> messages) {
      for (String message : messages) {
         errorMessages.add(new ResultMessage("9102", "E", "POT", message));
      }
   }

   public static void addWarnMessages(List<ResultMessage> errorMessages, List<String> messages) {
      for (String message : messages) {
         errorMessages.add(new ResultMessage("9102", "W", "POT", message));
      }
   }

   public static void addInfoMessages(List<ResultMessage> errorMessages, List<String> messages) {
      for (String message : messages) {
         errorMessages.add(new ResultMessage("INFO", "I", "POT", message));
      }
   }
}

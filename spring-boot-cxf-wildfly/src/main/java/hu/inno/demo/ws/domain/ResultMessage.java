/**
 * 
 */
package hu.inno.demo.ws.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <messageList>
 * <code>ERROR</code>
 * <severity>E</severity>
 * <sourceSystemCode>MY_OS</sourceSystemCode>
 * <text>Hiba szöveg 1 ...</text>
 * </messageList>
 * 
 * @author pbrindzik
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "code", "severity", "sourceSystemCode", "text" })
public class ResultMessage {

   protected String code;
   protected String severity;
   protected String sourceSystemCode;
   protected String text;

   public ResultMessage() {
      super();
   }

   public ResultMessage(String code, String severity, String sourceSystemCode, String text) {
      this.code = code;
      this.severity = severity;
      this.sourceSystemCode = sourceSystemCode;
      this.text = text;
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public String getSeverity() {
      return severity;
   }

   public void setSeverity(String severity) {
      this.severity = severity;
   }

   public String getSourceSystemCode() {
      return sourceSystemCode;
   }

   public void setSourceSystemCode(String sourceSystemCode) {
      this.sourceSystemCode = sourceSystemCode;
   }

   public String getText() {
      return text;
   }

   public void setText(String text) {
      this.text = text;
   }

}

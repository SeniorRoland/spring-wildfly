/**
 * 
 */
package hu.inno.demo.ws.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * @author pbrindzik
 * 
 */
@XmlType(name = "application-info-result-container-type")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ApplicationInfoResultContainer extends ResultContainer<ApplicationInfo> {

   protected ApplicationInfo result;

   public ApplicationInfoResultContainer() {
      super();
   }

   public ApplicationInfoResultContainer(ApplicationInfo result, ResultContext resultContext) {
      super(result, resultContext);
   }

   public ApplicationInfoResultContainer(ApplicationInfo result) {
      super(result);
   }

   public ApplicationInfo getResult() {
      return result;
   }

   public void setResult(ApplicationInfo result) {
      this.result = result;
   }

   @Override
   public void clearResult() {
      setResult(null);
   }
}

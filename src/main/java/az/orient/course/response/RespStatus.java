package az.orient.course.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement
public class RespStatus {
    private  Integer statusCode;
    private String   statusMessage;

    private  static final Integer SUCCES_CODE=1;
    private  static final String SUCCES_MESSAGE="succes";

   public  static RespStatus getSuccesMessage(){

       return new RespStatus(SUCCES_CODE,SUCCES_MESSAGE);
   }


}

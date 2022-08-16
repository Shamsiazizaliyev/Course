package az.orient.course.response;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@JacksonXmlRootElement
public class RespPaymentList {


     private List<RespPayment> paymentList;
     private  RespStatus status;

}

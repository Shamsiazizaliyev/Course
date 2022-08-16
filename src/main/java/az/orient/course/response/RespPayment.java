package az.orient.course.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.Date;

@Data
@JacksonXmlRootElement
public class RespPayment {


    private Long id;
    @JsonProperty(value = "student")
    private RespStudent respStudent;
    @JsonProperty(value = "teacher")
    private RespTeacher respTeacher;
    @JsonProperty(value = "lesson")
    private RespLesson respLesson;
    private Double amount;
    private Date paymentDate;
    private Integer active;



}

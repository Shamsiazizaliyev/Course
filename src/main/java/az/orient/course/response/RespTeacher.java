package az.orient.course.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.Date;

@Data
@JacksonXmlRootElement
public class RespTeacher {

    private Long teacherId;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private Date dob;
    private Integer expereince;
    private RespStatus status;
}

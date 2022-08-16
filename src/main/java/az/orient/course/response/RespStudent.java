package az.orient.course.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.Date;

@Data
@JacksonXmlRootElement
public class RespStudent {
    @JsonProperty(value = "studentId")
    private Long id;

    @JsonProperty(value = "studentName")
    private String name;

    @JsonProperty(value = "studentSurname")
    private String surname;

    @JsonProperty(value = "studentAddress")
    private String address;


    private String phone;


    private Date dob;

    private RespStatus status;


}

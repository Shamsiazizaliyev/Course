package az.orient.course.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;


import java.util.List;



import java.util.List;

@Data
@JacksonXmlRootElement
public class RespStudentList {
    @JsonProperty(value = "studentList")
   private List<RespStudent> respStudentList;

    private RespStatus status;


}

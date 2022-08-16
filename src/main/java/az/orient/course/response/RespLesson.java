package az.orient.course.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.Date;
@Data
@JacksonXmlRootElement
public class RespLesson {
    private Long lessonDd;
    private String name;
    private Double price;
    private Integer time;


}

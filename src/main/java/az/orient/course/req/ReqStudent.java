package az.orient.course.req;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.Date;




    @Data
    @JacksonXmlRootElement

    public class ReqStudent
    {

        private  Long studentId;
        private String name;
        private String surname;
        private String address;
        private Date dob;
        private String phone;



}

package az.orient.course.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;


@Data
@Table(name = "teacher")
@Entity
@DynamicInsert

public class Teacher {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String address;
    private Date dob;
    private String phone;
    private Integer workExperience;
    private Date dataDate;
    @ColumnDefault(value = "1")
    private Integer active;
}

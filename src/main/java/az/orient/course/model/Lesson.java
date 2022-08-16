package az.orient.course.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
@Data
@Table(name = "lesson")
@Entity
@DynamicInsert
public class Lesson {




        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private Integer time;
        private Double price;



}

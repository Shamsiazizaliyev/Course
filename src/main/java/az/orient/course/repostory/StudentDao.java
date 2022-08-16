package az.orient.course.repostory;


import az.orient.course.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends CrudRepository<Student,Long>{





    List<Student> findAllByActive(Integer active);

    Student findStudentByIdAndActive(Long id,Integer active);





}

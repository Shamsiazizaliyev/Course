package az.orient.course.repostory;

import az.orient.course.model.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentDao extends CrudRepository<Payment,Long> {

    List<Payment>findAllByActive(Integer active);
}

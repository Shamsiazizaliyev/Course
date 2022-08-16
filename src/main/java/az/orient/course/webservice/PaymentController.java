package az.orient.course.webservice;

import az.orient.course.response.RespPayment;
import az.orient.course.response.RespPaymentList;
import az.orient.course.response.RespStudentList;
import az.orient.course.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @GetMapping("/getPaymentList")
    public RespPaymentList getPaymentList(){

        return  service.getPaymentList();
    }
}

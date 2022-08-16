package az.orient.course.service;

import az.orient.course.response.RespPaymentList;
import org.springframework.stereotype.Service;


public interface PaymentService  {


    RespPaymentList getPaymentList();
}

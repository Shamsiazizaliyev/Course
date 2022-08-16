package az.orient.course.service;


import az.orient.course.enums.EnumAvealbleStatus;
import az.orient.course.exception.ExceptionConstants;
import az.orient.course.model.Payment;
import az.orient.course.repostory.PaymentDao;
import az.orient.course.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private  PaymentDao paymentDao;

    @Override
    public RespPaymentList getPaymentList() {
       RespPaymentList response =new RespPaymentList();

       try {
           List<RespPayment>respPayments=new ArrayList<>();

           List<Payment> paymentList= paymentDao.findAllByActive(EnumAvealbleStatus.ACTIVE.getValue());
          if(paymentList.isEmpty()){
              response.setStatus(new RespStatus(ExceptionConstants.PAYMENT_NOT_FOUND," PAYMENT_NOT_FOUND"));
              return response;
          }
          for(Payment payment:paymentList){
              RespPayment respPayment=new RespPayment();
              RespStudent respStudent= new RespStudent();
              respStudent.setId(payment.getStudent().getId());
              respStudent.setName(payment.getStudent().getName());
              respStudent.setSurname(payment.getStudent().getSurname());
              respStudent.setAddress(payment.getStudent().getAddress());
              respStudent.setPhone(payment.getStudent().getPhone());
              respStudent.setDob(payment.getStudent().getDob());

              respPayment.setRespStudent(respStudent);

              RespTeacher respTeacher= new RespTeacher();
              respTeacher.setTeacherId(payment.getTeacher().getId());
              respTeacher.setName(payment.getTeacher().getName());
              respTeacher.setSurname(payment.getTeacher().getSurname());
              respTeacher.setAddress(payment.getTeacher().getAddress());
              respTeacher.setAddress(payment.getTeacher().getAddress());
              respTeacher.setExpereince(payment.getTeacher().getWorkExperience());

              respPayment.setRespTeacher(respTeacher);

              RespLesson respLesson=new RespLesson();
              respLesson.setLessonDd(payment.getLesson().getId());
              respLesson.setName(payment.getLesson().getName());
              respLesson.setPrice(payment.getLesson().getPrice());
              respLesson.setTime(payment.getLesson().getTime());



              respPayment.setRespLesson(respLesson);

              respPayment.setAmount(payment.getAmount());

              respPayments.add(respPayment);






          }
              response.setPaymentList(respPayments);
              response.setStatus(RespStatus.getSuccesMessage());

       } catch (Exception e){
           e.printStackTrace();

       }


        return response;
    }
}

package az.orient.course.service;

import az.orient.course.req.ReqStudent;
import az.orient.course.response.RespStatus;
import az.orient.course.response.RespStudent;
import az.orient.course.response.RespStudentList;


public interface StudentService {


    RespStudentList getStudentList();

    RespStudent getStudentById(Long studentId);

    RespStatus addStudent(ReqStudent reqStudent);

    RespStatus  updateStudent(ReqStudent reqStudent);

    RespStatus  delete (Long studentId);



}

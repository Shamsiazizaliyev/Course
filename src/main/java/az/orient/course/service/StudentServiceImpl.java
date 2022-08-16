package az.orient.course.service;



import az.orient.course.enums.EnumAvealbleStatus;
import az.orient.course.exception.ExceptionConstants;
import az.orient.course.model.Student;
import az.orient.course.repostory.StudentDao;
import az.orient.course.req.ReqStudent;
import az.orient.course.response.RespStatus;
import az.orient.course.response.RespStudent;
import az.orient.course.response.RespStudentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


 @Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;





    @Override
    public RespStudentList getStudentList() {


        RespStudentList response= new RespStudentList();
        List<RespStudent>respStudenList = new ArrayList<>();

        try {

            List<Student> studentList=  studentDao.findAllByActive(EnumAvealbleStatus.ACTIVE.getValue());
            if(studentList.isEmpty())
            {
                response.setStatus(new RespStatus(ExceptionConstants.STUDENT_NOT_FOUND," Student not Found "));
                return response;
            }
            for(Student st: studentList)
            {
                RespStudent respStudent= new RespStudent();
                respStudent.setId(st.getId());
                respStudent.setName(st.getName());
                respStudent.setSurname(st.getSurname());
                respStudent.setAddress(st.getAddress());
                respStudent.setPhone(st.getPhone());
                respStudent.setDob(st.getDob());
                respStudenList.add(respStudent);

            }

            response.setRespStudentList(respStudenList);
            response.setStatus(RespStatus.getSuccesMessage());
            return  response;

        }

        catch (Exception e1){

            e1.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION," INTERNAL_EXCEPTION "));
            return response;

        }




    }

    @Override
    public RespStudent getStudentById(Long studentId) {
        RespStudent response= new RespStudent();
        try {

            if(studentId==null){
                response.setStatus(new RespStatus(ExceptionConstants.INVALID_REQUEST_DATAs," INVALID_REQUEST_DATA"));
                return response;
            }

            Student student=studentDao.findStudentByIdAndActive(studentId,EnumAvealbleStatus.ACTIVE.getValue());
            if(student==null){
                response.setStatus(new RespStatus(ExceptionConstants.STUDENT_NOT_FOUND," STUDENT_NOT_FOUND"));
                return response;
            }
            response.setId(studentId);
            response.setName(student.getName());
            response.setSurname(student.getSurname());
            response.setAddress(student.getAddress());
            response.setPhone(student.getPhone());
            response.setDob(student.getDob());
            response.setStatus(RespStatus.getSuccesMessage());
            return response;
        }
        catch (Exception e){


            e.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION," INTERNAL_EXCEPTION "));

        }

        return response;
    }

    @Override
    public RespStatus addStudent(ReqStudent reqStudent) {


        RespStatus response=null;

        try {
             String name=reqStudent.getName();
             String surname=reqStudent.getSurname();
             String address=reqStudent.getAddress();
             String phone=reqStudent.getPhone();
             Date dob=reqStudent.getDob();
             if(name ==null||surname==null){

                 response=new  RespStatus(ExceptionConstants.INVALID_REQUEST_DATAs," INVALID_REQUEST_DATA");
                 return response;
             }

             Student student= new Student();
             student.setName(name);
             student.setSurname(surname);
             student.setAddress(address);
             student.setPhone(phone);
             student.setDob(dob);
             studentDao.save(student);
             response=RespStatus.getSuccesMessage();




        }
        catch (Exception e){

            e.printStackTrace();
            response=(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION," INTERNAL_EXCEPTION "));

        }
        return response;
    }

    @Override
    public RespStatus updateStudent(ReqStudent reqStudent) {
        RespStatus response = null;

        try {
            String name = reqStudent.getName();
            String surname = reqStudent.getSurname();
            String address = reqStudent.getAddress();
            String phone = reqStudent.getPhone();
            Date dob = reqStudent.getDob();
            Long studentId = reqStudent.getStudentId();
            if ( name == null || surname == null) {


                response = new RespStatus(ExceptionConstants.INVALID_REQUEST_DATAs, " INVALID_REQUEST_DATA");
                return response;
            }


            Student student = studentDao.findStudentByIdAndActive(studentId, EnumAvealbleStatus.ACTIVE.getValue());
            if (student == null) {
                response = new RespStatus(ExceptionConstants.STUDENT_NOT_FOUND, " STUDENT_NOT_FOUND");
                return response;
            }

            student.setName(name);
            student.setSurname(surname);
            student.setAddress(address);
            student.setPhone(phone);
            student.setDob(dob);
            studentDao.save(student);
            response = RespStatus.getSuccesMessage();


        } catch (Exception e) {
            e.printStackTrace();

            response=new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION," INTERNAL_EXCEPTION ");

        }

        return response;
    }

    @Override
    public RespStatus delete(Long studentId) {
        RespStatus response = null;

        try {


            if ( studentId==null) {


                response = new RespStatus(ExceptionConstants.INVALID_REQUEST_DATAs, " INVALID_REQUEST_DATA");
                return response;
            }


            Student student = studentDao.findStudentByIdAndActive(studentId, EnumAvealbleStatus.ACTIVE.getValue());
            if (student == null) {
                response = new RespStatus(ExceptionConstants.STUDENT_NOT_FOUND, " STUDENT_NOT_FOUND");
                return response;
            }

            student.setActive(EnumAvealbleStatus.DEACTIVE.getValue());

            studentDao.save(student);
            response = RespStatus.getSuccesMessage();


        } catch (Exception e) {
            e.printStackTrace();
            response=new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION," INTERNAL_EXCEPTION ");

        }

        return response;
    }
}

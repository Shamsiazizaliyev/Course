package az.orient.course.webservice;


import az.orient.course.req.ReqStudent;
import az.orient.course.response.RespStatus;
import az.orient.course.response.RespStudent;
import az.orient.course.response.RespStudentList;
import az.orient.course.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private   StudentService studentService;





    @GetMapping("/getStudentList")
       public RespStudentList getStudentList(){

        return  studentService.getStudentList();
    }



    @RequestMapping(value = "/getStudentById/{studentId}",method = {RequestMethod.POST,RequestMethod.GET})

    public RespStudent getStudentById(@PathVariable Long studentId){


        return studentService.getStudentById(studentId);
    }

    @RequestMapping(value = "/addStudent",method = {RequestMethod.POST,RequestMethod.GET})
    public RespStatus addStudent(@RequestBody ReqStudent reqStudent) {

        return studentService.addStudent(reqStudent);
    }

    @PostMapping(value = "/updateStudent")
    public  RespStatus uptateStudent(@RequestBody ReqStudent reqStudent){
        return studentService.updateStudent(reqStudent);
    }

    @PostMapping(value = "/deleteStudent")
    public  RespStatus deleteStudent(@RequestParam ("studentId") Long studentId){
        return studentService.delete(studentId);
    }


}



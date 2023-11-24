package net.javaguides.springboot.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
@GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1, "Divyanshu", "Deepak");
       // return new ResponseEntity<>(student, HttpStatus.OK);
    return ResponseEntity.ok().header("Custome-header","Divyanshu").body(student);
    }

 //http://localhost:8090/students
   @GetMapping
    public ResponseEntity<List<Student>> grtStudent(){

    List<Student> students = new ArrayList<>();
    students.add(new Student(1, "Shubham","Deep"));
    students.add(new Student(2, "Romit","Halder"));
    students.add(new Student(3, "Ranjan","kumar"));
    students.add(new Student(4, "Abhinav","Nigam"));
    return ResponseEntity.ok(students);
    }

    //Springboot REST API with path variable
    //http://localhost:8090/students/1/ramesh/kumar here 1 is the {id}
    @GetMapping("{id}/{first-name}/{last-name}") //{id} - URI template Variable
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName,@PathVariable("last-name") String lastName){
    Student student =new Student(studentId, firstName, lastName);
     return ResponseEntity.ok(student);
    }

    //Springbbot REST API with Request Parameter
    // http://localhost:8090/students/query?id=1 -> called as query para meter
    @GetMapping("/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id){
    Student student = new Student(id, "Ramesh","Kumar");
    return ResponseEntity.ok(student);
    }

    //Springboot REST API that handel http post request
    //@postmapping and @requestbody is used here
    //@RequestBody -> uses Spring provider Http Message converter to convert JSON into java object
    //Post request -> It is used in creating new resource
    @PostMapping("/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
    //System.out.println(student.getId());
    //System.out.println(student.getFirstName());
    //System.out.println(student.getLastName());
    return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
    //PUT Request -> It is used in updating existing resource
 @PutMapping("/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){
     System.out.println(student.getFirstName());
     System.out.println(student.getLastName());
     return ResponseEntity.ok(student);
    }

    //Spring Boot REST API That handle HTTP DELETE Request -> deleting the existing resource
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
     System.out.println(studentId);
     return ResponseEntity.ok("Student deleted successfully");
    }
}

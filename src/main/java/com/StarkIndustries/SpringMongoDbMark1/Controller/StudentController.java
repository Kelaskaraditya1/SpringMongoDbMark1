package com.StarkIndustries.SpringMongoDbMark1.Controller;

import com.StarkIndustries.SpringMongoDbMark1.Model.Student;
import com.StarkIndustries.SpringMongoDbMark1.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    public StudentService studentService;

    @GetMapping("/greetings")
    public String greetings(){
        return "Greetings!!\nI am Optimus Prime";
    }

    @PostMapping("/insert")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){

        Student student1 = studentService.addStudent(student);
        if(student1==null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(student1);
    }

    @GetMapping("/student/{sid}")
    public ResponseEntity<Student> getStudent(@PathVariable("sid") int sid){
        Student student = studentService.getStudent(sid);
        if(student==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        if(studentService.getStudents().isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudents());
    }

    @PutMapping("/update/{sid}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("sid") int sid){
        Student student1 = studentService.updateStudent(sid,student);
        if(student==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(student1);
    }

    @DeleteMapping("/delete/{sid}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("sid") int sid){
        if(studentService.deleteStudent(sid))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping("/insert-students")
    public ResponseEntity<Void> addStudents(@RequestBody List<Student> studentList){
        boolean status = studentService.addStudents(studentList);
        if(status)
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

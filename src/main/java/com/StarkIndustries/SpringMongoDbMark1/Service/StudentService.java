package com.StarkIndustries.SpringMongoDbMark1.Service;

import com.StarkIndustries.SpringMongoDbMark1.Model.Student;
import com.StarkIndustries.SpringMongoDbMark1.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getStudent(int sid){
        if(studentRepository.existsById(sid)){
            Student student = studentRepository.findById(sid).get();
            return student;
        }
        return null;
    }


    public List<Student> getStudents(){
    return studentRepository.findAll();
    }

    public Student updateStudent(int sid,Student student){
        if(studentRepository.existsById(sid)){
            Student student1 = studentRepository.findById(sid).orElse(null);
                student1.setName(student.getName());
                student1.setAddress(student.getAddress());
                studentRepository.save(student1);
            return student1;
        }
        return null;
    }

    public boolean deleteStudent(int sid){

        if(studentRepository.existsById(sid)){
            studentRepository.deleteById(sid);
            return true;
        }

        return false;
    }

    public boolean addStudents(List<Student> studentList){
        if(!studentList.isEmpty()){
            studentRepository.saveAll(studentList);
            return true;
        }
        return false;
    }
}

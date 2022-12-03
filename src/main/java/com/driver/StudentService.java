package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String s, String t){
        studentRepository.addStudentTeacherPair(s,t);
    }

    public Student getStudentByName(String s){
        return studentRepository.getStudentByName(s);
    }

    public Teacher getTeacherByName(String t){
        return studentRepository.getTeacherByName(t);
    }

    public List<String> getStudentsByTeacherName(String t){
        return studentRepository.getStudentsByTeacherName(t);
    }

    public void deleteTeacherByName(String t){
         studentRepository.deleteTeacherByName(t);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }


}


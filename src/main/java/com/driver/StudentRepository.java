package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String , Student> studentMap = new HashMap<>();
    HashMap<String, Teacher> teacherMap = new HashMap<>();

    HashMap<String , List<String>> studentTeacherPairMap  = new HashMap<>();


    public void addStudent(Student student){
        studentMap.put(student.getName() , student);

    }

    public void addTeacher(Teacher teacher){
        teacherMap.put(teacher.getName() , teacher);
        System.out.println(teacherMap.toString());
    }


    public void addStudentTeacherPair(String studentName , String teacherName){
        if(studentMap.containsKey(studentName) && teacherMap.containsKey(teacherName)){
            List<String> list = new ArrayList<>();

            if(studentTeacherPairMap.containsKey(teacherName))
                 list = studentTeacherPairMap.get(teacherName);

            list.add(studentName);
            studentTeacherPairMap.put(teacherName , list);

            System.out.println("--" + studentTeacherPairMap.toString());
        }
    }


    public Student getStudentByName(String sName){
        return studentMap.get(sName);
    }

    public Teacher getTeacherByName(String tName){
        return teacherMap.get(tName);
    }


    public List<String> getStudentsByTeacherName(String tName){
        List<String> list = new ArrayList<>(studentTeacherPairMap.get(tName));
       // System.out.println(list.toString());
        return list;
    }

    public List<String> getAllStudents(){

        List<String> list = new ArrayList<>(studentMap.keySet());

        return list;
    }

    public void deleteTeacherByName(String tName){
        List<String> list = new ArrayList<>(studentTeacherPairMap.get(tName));

        System.out.println(list.toString());

        studentTeacherPairMap.remove(tName);
        teacherMap.remove(tName);

        for(String s: list){
            studentMap.remove(s);
        }


    }


    public void deleteAllTeachers(){
        HashSet<String> studentSet = new HashSet<>();

        for(String teacher : studentTeacherPairMap.keySet()){
            for (String student : studentTeacherPairMap.get(teacher)){
                studentSet.add(student);
            }
        }

        for (String student : studentSet){
            if (studentMap.containsKey(student)){
                studentMap.remove(student);
            }
        }



    }



}

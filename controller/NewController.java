//package com.in28minutes.springboot.controller;
//
//import com.in28minutes.springboot.model.NewStudent;
//import com.in28minutes.springboot.reponsitory.ReponsitoryCourse;
//import com.in28minutes.springboot.model.Course;
//import com.in28minutes.springboot.model.NewCourse;
//import com.in28minutes.springboot.model.Student;
//import com.in28minutes.springboot.reponsitory.ReponsitoryStudent;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//// controller cho bai tap buoi 8
//@RestController
//@RequestMapping(value = "/school/cousre")
//public class NewController {
//    @Autowired
//    ReponsitoryCourse reponsitoryCourse;
//
//    @Autowired
//    ReponsitoryStudent reponsitoryStudent;
//    // lay ra het sinh vien trong khoa hoc
//    @GetMapping(value = "/all")
//    public List<NewCourse> getAll(){
//    return reponsitoryCourse.findAll();
//    }
//
//    @PostMapping(value = "/load")
//    public List<NewCourse> persist(@RequestBody final  NewCourse newCourse){
//        reponsitoryCourse.save(newCourse);
//        return reponsitoryCourse.findAll();
//    }
////    Lay thong tin hoc vien
//    @GetMapping("getstudent/{id}")
//    public NewStudent getStudent(@PathVariable int id){
//
//        return  reponsitoryStudent.findById(id);
//    }
//    // dang kí khoa hoc cua student
//    @GetMapping("registration")
//    public void registStudentToCourse(){
//        // tao khoa hoc vao bang course
//        NewCourse newcourseA = new NewCourse(4,"Course A");
//        NewCourse newcourseB = new NewCourse(5,"Course B");
//
//        // them sinh vien vao bang student
//        NewStudent  newStudent = new NewStudent(5,"Jonh");
//        List<NewCourse> courseList = new ArrayList<>();
//        // them khoa hoc vao danh sach
//        courseList.add(newcourseA);
//        courseList.add(newcourseB);
//
//        newStudent.setNewCourses(courseList);
//        this.reponsitoryStudent.save(newStudent);
//    }
//    //
//}

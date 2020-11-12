//package com.in28minutes.springboot.model;
//
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
////tao khoa hoc cho cac sinh vien
//@Entity// không khai báo tên vì nó chính là tên class 'NewCourse'
//@Table(name = "course")// khai báo tên trong DB
////Nếu không khai báo thì nó sẽ tự hiển "NewCourse" là ten lớp Entity và DB
//public class NewCourse { //POJO
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)// id tu dong tang
//    // tham chieu den column id trong Mysql
//    @Column(name ="idcourse")
//    private Integer iId;
//    // tham chieu den column ten trong mysql
//    @Column(name ="nameCourse")
//    private String strNameCourse;
//
//    // ket noi n-n cua sudent va course
//    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "newCourses")
//
//    //tao 1 danh sach sinh vien
//    @JsonBackReference
//    private List<NewStudent>  newStudents;
//
//
//    public NewCourse(int iId, String strNewCourse) {
//        this.iId = iId;
//        this.strNameCourse = strNewCourse;
//    }
//
//    public NewCourse() {
//    }
//
//    public int getiId() {
//        return iId;
//    }
//
//    public void setiId(int iId) {
//        this.iId = iId;
//    }
//
//    public String getStrNewCourse() {
//        return strNameCourse;
//    }
//
//    public void setStrNewCourse(String strNewCourse) {
//        this.strNameCourse = strNewCourse;
//    }
//
//    @Override
//    public String toString() {
//        return "NewCourse{" +
//                "iId=" + iId +
//                ", strNameCourse='" + strNameCourse + '\'' +
//                ", newStudents=" + newStudents +
//                '}';
//    }
//}

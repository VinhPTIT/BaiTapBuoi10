//package com.in28minutes.springboot.model;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.sun.javafx.geom.transform.Identity;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//// tao ra bang sinh vien
//@Entity
//@Table (name = "student")//tham chieu toi bang trong sql
//public class NewStudent { //POJO
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)// id tu dong tang
//    // tham chieu den cot id trong sql
//    @Column (name = "idstudent")
//    private int iId;
//    // tham chieu den cot name trong sql
//    @Column ( name = "nameStudent")
//    private String strNameStudent;
//
//    // Dùng EAGER để khi load du lieu len cho Student thì co cả ds Course còn dùng Lazy thì phải get vao moi mang ra đươc
//    // dùng unllable=false phải có data không thi no sẽ lỗi
//    // Tạo bảng trung gian giua hai bảng
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "course_student", joinColumns = {
//    @JoinColumn(name = "idstudent", nullable = false)}, inverseJoinColumns ={
//    @JoinColumn(name = "idcourse", nullable = false)})
//
//    @JsonBackReference
//    private List<NewCourse> newCourses ;
//
//    public NewStudent() {
//    }
//
//    public NewStudent(int iId, String strNameStudent) {
//        this.iId = iId;
//        this.strNameStudent = strNameStudent;
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
//    public String getStrNameStudent() {
//        return strNameStudent;
//    }
//
//    public void setStrNameStudent(String strNameStudent) {
//        this.strNameStudent = strNameStudent;
//    }
//
//    public List<NewCourse> getNewCourses() {
//        return newCourses;
//    }
//
//    public void setNewCourses(List<NewCourse> newCourses) {
//        this.newCourses = newCourses;
//    }
//
//    @Override
//    public String toString() {
//        return "NewStudent{" +
//                "iId=" + iId +
//                ", strNameStudent='" + strNameStudent + '\'' +
//                ", newCourses=" + newCourses +
//                '}';
//    }
//}

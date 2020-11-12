package com.in28minutes.springboot.model;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 746237126088051312L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int iId;
    @Column(name = "name",length = 45)
    private String strName;
    @Column(name = "age")
    private int iAge;
    @Column(name = "email", length = 45)
    private String strEmail;
    @Transient
    private String strNameUS;

    public Customer() {
    }

    public Customer(int iId, String strName, int iAge, String strEmail){
        this.iId=iId;
        this.strName=strName;
        this.iAge=iAge;
        this.strEmail=strEmail;

    }

    public Customer(int id, String name, String nameUS, int age, String email) {
        this.iId=id;
        this.strName=name;
        this.strNameUS=nameUS;
        this.iAge=age;
        this.strEmail=email;
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public int getiAge() {
        return iAge;
    }

    public void setiAge(int iAge) {
        this.iAge = iAge;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public String getStrNameUS() {
        return strNameUS;
    }

    public void setStrNameUS(String strNameUS) {
        this.strNameUS = strNameUS;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "iId=" + iId +
                ", strName='" + strName + '\'' +
                ", iAge=" + iAge +
                ", strEmail='" + strEmail + '\'' +
                '}';
    }
}

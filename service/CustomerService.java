package com.in28minutes.springboot.service;

//import com.in28minutes.springboot.model.Customer;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;

//@Component //bean in java
//public class CustomerService {
//    private static ArrayList<Customer> customers = new ArrayList<>();
//    static {
//        // Khoi tao du lieu
//        customers.add(new Customer(1, "Nguyen Van A", 30 , "a@gmail.com"));
//        customers.add(new Customer(2, "Nguyen Van B", 33 , "b@gmail.com"));
//        customers.add(new Customer(3, "Nguyen Van C", 34 , "c@gmail.com"));
//
//    }
//    //them khach hang vao danh sach
//    public Customer addCustomer(Customer customer){
//        customer.setiId(customers.size()+1);
//        customers.add(customer);
//        return  customer;
//    }
//    // lay tat ca khach hang
//    public ArrayList<Customer> getAllCustomers (){
//        return customers;
//    }
//
//    // lay khach hang bang id
//    public Customer retrieveCustomer(int customerId){
//        for (Customer customer: customers){
//            if(customer.getiId()==customerId){
//                return customer;
//            }
//        }
//        return null;
//    }
//
//    // xoa tai khoan khach hang
//    public boolean deleteCustomerById (int id) {
//        return customers.removeIf(t -> t.getiId()== id);
//    }
//}
import com.in28minutes.springboot.model.Customer;
import com.in28minutes.springboot.reponsitory.JReponsitoryCostomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class CustomerService {
    private static ArrayList<Customer> customers = new ArrayList<>();
    @Autowired
    private JReponsitoryCostomer jReponsitoryCostomer;

    @Autowired
    private MessageSource messageSource;

    // tim tat ca khach hang
    public List<Customer> getAllCustomer() {
        return jReponsitoryCostomer.findAll();
    }


    // lây khach hang bằng id từ danh sach khach hang
    public Optional<Customer> getCustomerById(Integer customerId) {
        return jReponsitoryCostomer.findById(customerId);
    }

    // xoa khách hàng bàng id
    public boolean deleteCustomerById (int id) {
        // nếu phần tử không tồn tại nhẩy vào exception
        try {
            jReponsitoryCostomer.deleteById(id);
        } catch (Exception e) {
            System.out.println("Không còn khách hàng để xóa");
            return false;
        }
        // kiểm tra phần tử xóa chưa
        if (getCustomerById(id) == null)
            return true;
        return false;
    }

//    public Customer addCustomer(Customer customer){
//       customer.setiId(customers.size());
//        customers.add(customer);
//        return  customer;
//    }

    // doc file ten tieng anh
    public String getMessage(String code, HttpServletRequest request) {
        return messageSource.getMessage(code, null, Locale.getDefault());
    }

}
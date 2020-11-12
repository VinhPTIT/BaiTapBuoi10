package com.in28minutes.springboot.controller;

//import java.util.ArrayList;
//import com.in28minutes.springboot.model.Customer;
//import com.in28minutes.springboot.model.CustomerDelete;
//import com.in28minutes.springboot.service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;

import com.in28minutes.springboot.model.Customer;
import com.in28minutes.springboot.model.CustomerDelete;
import com.in28minutes.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//controller cho bai tap buoi 7
//@RestController
//public class CustomerController {
//    @Autowired
//    private CustomerService customerService;
//
//    //Dua ra khach hang duoc tao ra
//    @PostMapping("customers/create")
//    public Customer addCustomer(@RequestBody Customer customer){
//        return customerService.addCustomer(customer);
//    }
//    // Lay danh sach khach hang
//    @GetMapping("customers/list")
//    public ArrayList<Customer> getAllCustomer(){
//        return customerService.getAllCustomers();
//    }
//    // lay khach hang theo id (1,2,3)
//    @GetMapping("customer/{cusId}")
//    public Customer getCustomerById(@PathVariable int cusId) {
//        return customerService.retrieveCustomer(cusId);
//    }
//    // xoa khach hang theo id
//    @GetMapping("customer/delete/{cusId}")
//    public CustomerDelete deleteCustomerById(@PathVariable int cusId) {
//        CustomerDelete customerDelete = new CustomerDelete();
//        customerDelete.setSuccess(customerService.deleteCustomerById(cusId));
//        return customerDelete;
//    }
//}
//Bai tap buoi 10
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // đưa ra 1 danh sach khách hang
    @GetMapping("/customer/list")
    public List<Customer> getCustomerList() {
        return customerService.getAllCustomer();
    }
    // đưa khach hang theo id
    @GetMapping("/customer/{customerId}")
    public Customer getCustomerById(@PathVariable Integer customerId) {
        return customerService.getCustomerById(customerId).get();
    }
    // xoa khách hang khoi danh sach
    @GetMapping("/customer/delete/{customerId}")
    public CustomerDelete deleteCustomerById(@PathVariable Integer customerId) {
        CustomerDelete customerDelete = new CustomerDelete();
        customerDelete.setSuccess(customerService.deleteCustomerById(customerId));
        return customerDelete;
    }

//    @PostMapping("customer/add")
//    public Customer addCustomer(@RequestBody Customer customer){
//        return customerService.addCustomer(customer);
//    }

    //Hiển thị tên khách hàng theo id bằng tiếng anh
    @GetMapping("/customer/convert/{customerId}")
    public Customer getMessage(@PathVariable Integer customerId, HttpServletRequest request) {
        String nameUS = customerService.getMessage(String.valueOf(customerId), request);
        System.err.println(nameUS);

        // Lấy ra toàn bộ thông tin khách hàng theo id
        Customer customer1 = customerService.getCustomerById(customerId).get();
        int id=customer1.getiId();
        String name=customer1.getStrName();
        int age = customer1.getiAge();
        String email=customer1.getStrEmail();

        // Thêm thuộc tính nameUS vào danh sach khach hang
        Customer customer = new Customer(id, name, nameUS, age, email);
        return customer;
    }
}

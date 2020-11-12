package com.in28minutes.springboot.reponsitory;

import com.in28minutes.springboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JReponsitoryCostomer extends JpaRepository<Customer, Integer> {
}

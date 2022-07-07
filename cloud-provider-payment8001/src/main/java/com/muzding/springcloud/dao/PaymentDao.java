package com.muzding.springcloud.dao;


import com.muzding.springcloud.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDao extends JpaRepository<Payment,Long>{

}

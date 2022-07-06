package com.liding.springcloud.dao;

import com.liding.springcloud.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDao extends JpaRepository<Payment,Long>{

}

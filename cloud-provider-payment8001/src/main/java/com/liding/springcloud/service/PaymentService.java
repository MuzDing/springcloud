package com.liding.springcloud.service;

import com.liding.springcloud.dao.PaymentDao;
import com.liding.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentDao paymentDao;
    public void insertPayment(Payment pament){
        paymentDao.save(pament);
    }

    public Optional<Payment> fingPaymentByid(Long id){
        return paymentDao.findById(id);
    }


}

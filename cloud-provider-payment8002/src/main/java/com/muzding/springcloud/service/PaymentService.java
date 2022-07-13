package com.muzding.springcloud.service;

import com.muzding.springcloud.dao.PaymentDao;
import com.muzding.springcloud.entity.Payment;
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

    public Optional<Payment> findPaymentByid(Long id){
        return paymentDao.findById(id);
    }


}

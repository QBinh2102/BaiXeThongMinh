/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.repositories.impl;

import com.bxtm.pojo.Loaingay;
import com.bxtm.repositories.LoaingayRepository;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author toquocbinh2102
 */
@Repository
@Transactional
public class LoaingayRepositoryImpl implements LoaingayRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Loaingay> getAllLoaiNgay() {
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("FROM LoaiNgay", Loaingay.class);
        return query.getResultList();
    }

    @Override
    public Loaingay createOrUpdate(Loaingay loaiNgay) {
        Session s = this.factory.getObject().getCurrentSession();
        if (loaiNgay.getId() == null) {
            s.persist(loaiNgay);
        } else {
            s.merge(loaiNgay);
        }
        s.refresh(loaiNgay);
        return loaiNgay;
    }
}

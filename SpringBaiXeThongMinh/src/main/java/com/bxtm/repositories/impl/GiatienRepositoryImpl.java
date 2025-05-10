package com.bxtm.repositories.impl;

import com.bxtm.pojo.Giatien;
import com.bxtm.repositories.GiatienRepository;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author toquocbinh2102
 */
@Repository
@Transactional
public class GiatienRepositoryImpl implements GiatienRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Giatien> getGiaTien(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery<Giatien> q = cb.createQuery(Giatien.class);
        Root root = q.from(Giatien.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String giaTien = params.get("giaTien");
            if(giaTien != null && !giaTien.isEmpty()){
                predicates.add(cb.equal(root.get("giaTien").as(String.class), giaTien));
            }
            
            String baiDo_id = params.get("idBaiDo");
            if (baiDo_id != null && !baiDo_id.isEmpty()) {
                predicates.add(cb.equal(root.get("idBaiDo").get("id").as(String.class), baiDo_id));
            }

            q.where(predicates.toArray(Predicate[]::new));
        }

        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public Giatien createOrUpdate(Giatien giaTien) {
        Session s = this.factory.getObject().getCurrentSession();
        if (giaTien.getId() == null) {
            s.persist(giaTien);
        } else {
            s.merge(giaTien);
        }
        s.refresh(giaTien);
        return giaTien;
    }
}

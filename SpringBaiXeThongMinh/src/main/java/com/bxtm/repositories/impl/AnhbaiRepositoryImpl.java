/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.repositories.impl;

import com.bxtm.pojo.Anhbai;
import com.bxtm.repositories.AnhbaiRepository;
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

/**
 *
 * @author toquocbinh2102
 */
@Repository
@Transactional
public class AnhbaiRepositoryImpl implements AnhbaiRepository{

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Anhbai> getAnhBai(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery<Anhbai> q = cb.createQuery(Anhbai.class);
        Root root = q.from(Anhbai.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

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
    public Anhbai createOrUpdate(Anhbai anhBai) {
        Session s = this.factory.getObject().getCurrentSession();
        if (anhBai.getId() == null) {
            s.persist(anhBai);
        } else {
            s.merge(anhBai);
        }

        s.refresh(anhBai);
        return anhBai;
    }
}

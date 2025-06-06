package com.bxtm.repositories.impl;

import com.bxtm.hibernate.HibernateUtils;
import com.bxtm.pojo.Giatien;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author toquocbinh2102
 */
public class GiatienRepositoryImpl {
    public List<Giatien> getBaiDo(Map<String,String> params){
        try(Session s = HibernateUtils.getFACTORY().openSession()){
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<Giatien> q = cb.createQuery(Giatien.class);
            Root root = q.from(Giatien.class);
            q.select(root);
            
            if(params != null){
                List<Predicate> predicates = new ArrayList<>();
                
                String baiDo_id = params.get("idBaiDo");
                if(baiDo_id!=null && !baiDo_id.isEmpty())
                    predicates.add(cb.equal(root.get("idBaiDo").get("id").as(String.class), baiDo_id));
                
                q.where(predicates.toArray(Predicate[]::new));
            }
            
            Query query = s.createQuery(q);
            
            return query.getResultList();
        }
    }
    
    public Giatien createOrUpdate(Giatien giaTien){
        try(Session s = HibernateUtils.getFACTORY().openSession()){
            if(giaTien.getId() == null){
                s.persist(giaTien);
            }else
                s.merge(giaTien);
            s.refresh(giaTien);
        }
        return giaTien;
    }
}

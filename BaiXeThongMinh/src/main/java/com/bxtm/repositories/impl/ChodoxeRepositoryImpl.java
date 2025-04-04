/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.repositories.impl;

import com.bxtm.hibernate.HibernateUtils;
import com.bxtm.pojo.Chodoxe;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;

/**
 *
 * @author GIGA
 */
public class ChodoxeRepositoryImpl {
    public List<Chodoxe> getChoDo(Map<String,String> params){
        try(Session s = HibernateUtils.getFACTORY().openSession()){
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<Chodoxe> q = cb.createQuery(Chodoxe.class);
            Root root = q.from(Chodoxe.class);
            q.select(root);
            
            if(params != null){
                List<Predicate> predicates = new ArrayList<>();
                
                String baiDo_id = params.get("baiDo_id");
                if(baiDo_id !=null && !baiDo_id.isEmpty())
                    predicates.add(cb.equal(root.get("baiDoXeid").get("id").as(String.class), baiDo_id));
                
                String loaiXe_id = params.get("loaiXe_id");
                if(loaiXe_id!=null && !loaiXe_id.isEmpty())
                    predicates.add(cb.equal(root.get("loaiXeid").get("id").as(String.class), loaiXe_id));
                
                String trangThai = params.get("trangThai");
                if(trangThai!=null && !trangThai.isEmpty())
                    predicates.add(cb.equal(root.get("trangThai").as(String.class), trangThai));
                
                q.where(predicates.toArray(Predicate[]::new));
            }
            
            Query query = s.createQuery(q);
            
            return query.getResultList();
        }
    }
    
}

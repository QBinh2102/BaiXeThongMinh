/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.repositories.impl;

import com.bxtm.hibernate.HibernateUtils;
import com.bxtm.pojo.Danhgia;
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
public class DanhgiaRepositoryImpl {
    public List<Danhgia> getDanhGia(Map<String,String> params){
        try(Session s = HibernateUtils.getFACTORY().openSession()){
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<Danhgia> q = cb.createQuery(Danhgia.class);
            Root root = q.from(Danhgia.class);
            q.select(root);
            
            if(params!=null){
                List<Predicate> predicates = new ArrayList<>();
                
                String choDo_id = params.get("choDo_id");
                if(choDo_id!=null&&!choDo_id.isEmpty()){
                    predicates.add(cb.equal(root.get("choDoXeid").get("id"), choDo_id));
                }
                
                String rating = params.get("rating");
                if(rating!=null&&!rating.isEmpty()){
                    predicates.add(cb.equal(root.get("rating"), rating));
                }
                
                q.where(predicates.toArray(Predicate[]::new));
            }
            
            Query query = s.createQuery(q);
            
            return query.getResultList();
        }
    }
}

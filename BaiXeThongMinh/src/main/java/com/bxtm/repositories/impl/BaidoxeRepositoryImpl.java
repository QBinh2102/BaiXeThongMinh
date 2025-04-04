package com.bxtm.repositories.impl;

import com.bxtm.hibernate.HibernateUtils;
import com.bxtm.pojo.Baidoxe;
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
 * @author GIGA
 */
public class BaidoxeRepositoryImpl {
    public List<Baidoxe> getBaiDo(Map<String,String> params){
        try(Session s = HibernateUtils.getFACTORY().openSession()){
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<Baidoxe> q = cb.createQuery(Baidoxe.class);
            Root root = q.from(Baidoxe.class);
            q.select(root);
            
            if(params != null){
                List<Predicate> predicates = new ArrayList<>();
                
                String trangThai = params.get("trangThai");
                if(trangThai!=null && !trangThai.isEmpty())
                    predicates.add(cb.equal(root.get("trangThai").as(String.class), trangThai));
                
                String viTri = params.get("viTri");
                if(viTri!=null && !viTri.isEmpty())
                    predicates.add(cb.like(root.get("diaChi").as(String.class), String.format("%%%s%%", viTri)));
                
                q.where(predicates.toArray(Predicate[]::new));
            }
            
            Query query = s.createQuery(q);
            
            return query.getResultList();
        }
    }
}

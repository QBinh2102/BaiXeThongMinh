/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.repositories.impl;

import com.bxtm.hibernate.HibernateUtils;
import com.bxtm.pojo.Soden;
import jakarta.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author GIGA
 */
public class SodenRepositoryImpl {
    public Soden getSoDen(String nguoiDung_id){
        try(Session s = HibernateUtils.getFACTORY().openSession()){
            Query query = s.createNamedQuery("Soden.findById", Soden.class);
            query.setParameter("id", nguoiDung_id);
            
            return (Soden) query.getSingleResult();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.services.impl;

import com.bxtm.pojo.Giatien;
import com.bxtm.repositories.GiatienRepository;
import com.bxtm.services.GiatienService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author toquocbinh2102
 */
@Service
public class GiatienServiceImpl implements GiatienService{
    @Autowired
    private GiatienRepository giaTienRepo;

    @Override
    public List<Giatien> getGiaTien(Map<String, String> params) {
        return this.giaTienRepo.getGiaTien(params);
    }

    @Override
    public Giatien createOrUpdate(Giatien giaTien) {
        return this.giaTienRepo.createOrUpdate(giaTien);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.services.impl;

import com.bxtm.pojo.Anhbai;
import com.bxtm.repositories.AnhbaiRepository;
import com.bxtm.services.AnhbaiService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author toquocbinh2102
 */
@Service
public class AnhbaiServiceImpl implements AnhbaiService{
    @Autowired
    private AnhbaiRepository anhBaiRepo;

    @Override
    public List<Anhbai> getAnhBai(Map<String, String> params) {
        return this.anhBaiRepo.getAnhBai(params);
    }

    @Override
    public Anhbai createOrUpdate(Anhbai anhBai) {
        return this.anhBaiRepo.createOrUpdate(anhBai);
    }
    
}

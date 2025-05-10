package com.bxtm.services.impl;


import com.bxtm.pojo.Soden;
import com.bxtm.repositories.SodenRepository;
import com.bxtm.services.SodenService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author toquocbinh2102
 */
@Service
public class SodenServiceImpl implements SodenService{
    @Autowired
    private SodenRepository soDenRepo;

    @Override
    public List<Soden> getSoDen(Map<String, String> params) {
        return this.soDenRepo.getSoDen(params);
    }

    @Override
    public Soden createOrUpdate(Soden soDen) {
        return this.soDenRepo.createOrUpdate(soDen);
    }
    
}

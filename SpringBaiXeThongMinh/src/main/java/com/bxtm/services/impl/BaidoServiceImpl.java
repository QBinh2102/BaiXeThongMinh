/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.services.impl;

import com.bxtm.pojo.Baido;
import com.bxtm.repositories.BaidoRepository;
import com.bxtm.services.BaidoService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author toquocbinh2102
 */
@Service
public class BaidoServiceImpl implements BaidoService{
    @Autowired
    private BaidoRepository baiDoRepo;

    @Override
    public List<Baido> getBaiDo(Map<String, String> params) {
        return this.baiDoRepo.getBaiDo(params);
    }

    @Override
    public Baido getBaiDoById(int id) {
        return this.baiDoRepo.getBaiDoById(id);
    }

    @Override
    public Baido createOrUpdate(Baido baiDo) {
        return this.baiDoRepo.createOrUpdate(baiDo);
    }
    
}

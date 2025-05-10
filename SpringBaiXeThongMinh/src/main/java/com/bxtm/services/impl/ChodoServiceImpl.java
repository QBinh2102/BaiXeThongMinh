/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.services.impl;

import com.bxtm.pojo.Chodo;
import com.bxtm.repositories.ChodoRepository;
import com.bxtm.services.ChodoService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author toquocbinh2102
 */
@Service
public class ChodoServiceImpl implements ChodoService{
    @Autowired
    private ChodoRepository choDoRepo;

    @Override
    public List<Chodo> getChoDo(Map<String, String> params) {
        return this.choDoRepo.getChoDo(params);
    }

    @Override
    public Chodo createOrUpdate(Chodo choDo) {
        return this.choDoRepo.createOrUpdate(choDo);
    }
    
}

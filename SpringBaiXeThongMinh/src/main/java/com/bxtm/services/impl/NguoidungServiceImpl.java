/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.services.impl;

import com.bxtm.pojo.Nguoidung;
import com.bxtm.repositories.NguoidungRepository;
import com.bxtm.services.NguoidungService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author toquocbinh2102
 */
@Service
public class NguoidungServiceImpl implements NguoidungService{
    @Autowired
    private NguoidungRepository nguoiDungRepo;

    @Override
    public List<Nguoidung> getNguoiDung(Map<String, String> params) {
        return this.nguoiDungRepo.getNguoiDung(params);
    }

    @Override
    public Nguoidung createOrUpdate(Nguoidung nguoiDung) {
        return this.nguoiDungRepo.createOrUpdate(nguoiDung);
    }
    
}

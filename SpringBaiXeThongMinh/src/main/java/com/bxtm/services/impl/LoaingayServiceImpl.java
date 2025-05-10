/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.services.impl;

import com.bxtm.pojo.Loaingay;
import com.bxtm.repositories.LoaingayRepository;
import com.bxtm.services.LoaingayService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author toquocbinh2102
 */
@Service
public class LoaingayServiceImpl implements LoaingayService{
    @Autowired
    private LoaingayRepository loaiNgayRepo;

    @Override
    public List<Loaingay> getAllLoaiNgay() {
        return this.loaiNgayRepo.getAllLoaiNgay();
    }

    @Override
    public Loaingay createOrUpdate(Loaingay loaiNgay) {
        return this.loaiNgayRepo.createOrUpdate(loaiNgay);
    }
    
}

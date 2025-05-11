/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.services.impl;

import com.bxtm.pojo.Baido;
import com.bxtm.pojo.Danhgia;
import com.bxtm.pojo.Giatien;
import com.bxtm.repositories.AnhbaiRepository;
import com.bxtm.repositories.BaidoRepository;
import com.bxtm.services.BaidoService;
import com.bxtm.services.GiatienService;
import java.util.Date;
import java.util.HashMap;
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
    @Autowired
    private GiatienService giaTienService;

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

    @Override
    public List<Danhgia> getDanhGiaByBaiDo(int id) {
        return this.baiDoRepo.getDanhGiaByBaiDo(id);
    }

    @Override
    public Map<Integer, List<Giatien>> getBaiDoWithGiaTienByLoaiNgay(List<Baido> baidos, int idLoaiNgay) {
        Map<Integer,List<Giatien>> giaTienMap = new HashMap<>();
        Date now = new Date();
        for(Baido bd : baidos){
            List<Giatien> gt = this.giaTienService.getGiaTienByBaiDo(bd.getId(), now, idLoaiNgay);
            giaTienMap.put(bd.getId(), gt);
        }
        return giaTienMap;
    }
}

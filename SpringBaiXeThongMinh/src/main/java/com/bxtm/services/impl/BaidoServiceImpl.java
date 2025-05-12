/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.services.impl;

import com.bxtm.pojo.Baido;
import com.bxtm.pojo.Chodo;
import com.bxtm.pojo.Danhgia;
import com.bxtm.repositories.BaidoRepository;
import com.bxtm.repositories.ChodoRepository;
import com.bxtm.services.BaidoService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private ChodoRepository choDoRepo; 
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Baido> getBaiDo(Map<String, String> params) {
        return this.baiDoRepo.getBaiDo(params);
    }

    @Override
    public Baido getBaiDoById(int id) {
        Baido baiDo = this.baiDoRepo.getBaiDoById(id);
        baiDo.setFile(null);
        return baiDo;
    }
    
    @Override
    public Baido createOrUpdate(Baido baiDo) {
        if(baiDo.getId()==null){
            baiDo.setTrangThai("Hoạt động");
        }
        if(baiDo.getFile() != null && !baiDo.getFile().isEmpty()){
                try {
                    Map res = cloudinary.uploader().upload(baiDo.getFile().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                    baiDo.setAnhBai(res.get("secure_url").toString());
                } catch (IOException ex) {
                    Logger.getLogger(BaidoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        return this.baiDoRepo.createOrUpdate(baiDo);
    }

    @Override
    public List<Danhgia> getDanhGiaByBaiDo(int id) {
        return this.baiDoRepo.getDanhGiaByBaiDo(id);
    }
//   @Override
//    public BigDecimal tinhTien(Baido baido, LocalDateTime start, LocalDateTime end) {
//        if (start == null || end == null || end.isBefore(start)) {
//            return BigDecimal.ZERO;
//        }
//        Duration duration = Duration.between(start, end);
//        long minutes = duration.toMinutes();
//
//        long hours = minutes / 60;
//        if (minutes % 60 != 0) {
//            hours++;
//        }
//        BigDecimal gia = baido.getGiaTien(); 
//        return gia.multiply(BigDecimal.valueOf(hours));
//    }
//    @Override
//    public List<Chodo> getChoDoTrong(int idBaiDo, LocalDateTime start, LocalDateTime end) {
//        return choDoRepo.getChoDoTrong(idBaiDo, start, end);
//    }

}

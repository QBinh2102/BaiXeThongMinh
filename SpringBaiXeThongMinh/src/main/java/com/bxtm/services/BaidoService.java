/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bxtm.services;

import com.bxtm.pojo.Baido;
import com.bxtm.pojo.Danhgia;
import com.bxtm.pojo.Chodo;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 *
 * @author toquocbinh2102
 */
public interface BaidoService {
    List<Baido> getBaiDo(Map<String,String> params);
    Baido getBaiDoById(int id);
    Baido createOrUpdate(Baido baiDo);
    List<Danhgia> getDanhGiaByBaiDo(int id);
//    BigDecimal tinhTien (Baido baido, LocalDateTime startTime, LocalDateTime endTime);
//    List<Chodo> getChoDoTrong(int idBaiDo, LocalDateTime start, LocalDateTime end);
}


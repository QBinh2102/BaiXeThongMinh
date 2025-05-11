/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bxtm.services;

import com.bxtm.pojo.Giatien;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author toquocbinh2102
 */
public interface GiatienService {
    List<Giatien> getGiaTien(Map<String,String> params);
    Giatien createOrUpdate(Giatien giaTien);
    List<Giatien> getGiaTienByBaiDo(int idBaiDo, Date selectedTime, int loaiNgay);
}

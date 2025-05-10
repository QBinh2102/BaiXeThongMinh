/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bxtm.services;

import com.bxtm.pojo.Nguoidung;
import java.util.List;
import java.util.Map;

/**
 *
 * @author toquocbinh2102
 */
public interface NguoidungService {
    List<Nguoidung> getNguoiDung(Map<String,String> params);
    Nguoidung createOrUpdate(Nguoidung nguoiDung);
}

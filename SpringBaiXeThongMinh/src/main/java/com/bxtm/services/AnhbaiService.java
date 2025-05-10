/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bxtm.services;

import com.bxtm.pojo.Anhbai;
import java.util.List;
import java.util.Map;

/**
 *
 * @author toquocbinh2102
 */
public interface AnhbaiService {
    List<Anhbai> getAnhBai(Map<String, String> params);
    Anhbai createOrUpdate(Anhbai anhBai);
}

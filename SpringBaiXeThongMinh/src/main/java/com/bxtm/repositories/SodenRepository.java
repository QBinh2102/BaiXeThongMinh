/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bxtm.repositories;

import com.bxtm.pojo.Soden;
import java.util.List;
import java.util.Map;

/**
 *
 * @author toquocbinh2102
 */
public interface SodenRepository {
    List<Soden> getSoDen(Map<String,String> params);
    Soden createOrUpdate(Soden soDen);
}

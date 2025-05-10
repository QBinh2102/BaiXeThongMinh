/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bxtm.repositories;

import com.bxtm.pojo.Loaingay;
import java.util.List;

/**
 *
 * @author toquocbinh2102
 */
public interface LoaingayRepository {
    List<Loaingay> getAllLoaiNgay();
    Loaingay createOrUpdate(Loaingay loaiNgay);
}

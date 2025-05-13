/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.controllers;

import com.bxtm.pojo.Hoadon;
import com.bxtm.services.HoadonService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author toquocbinh2102
 */
@RestController
@RequestMapping("/api")
public class ApiHoadonController {
    @Autowired
    private HoadonService hoaDonService;
    
    @GetMapping("/hoadons")
    public ResponseEntity<List<Hoadon>> getHoaDon(){
        return new ResponseEntity<>(this.hoaDonService.getHoaDon(null), HttpStatus.OK);
    }
    
    @GetMapping("/hoadons/nguoidung")
    public ResponseEntity<List<Hoadon>> getHoaDonByNguoiDung(@RequestParam("idNguoiDung") String id){
        Map<String,String> params = new HashMap<>();
        params.put("idNguoiDung", id);
        return new ResponseEntity<>(this.hoaDonService.getHoaDon(params), HttpStatus.OK);
    }
}

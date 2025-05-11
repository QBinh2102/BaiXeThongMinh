/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.controllers;

import com.bxtm.pojo.Baido;
import com.bxtm.pojo.Danhgia;
import com.bxtm.services.BaidoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author toquocbinh2102
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiBaidoController {
    @Autowired
    private BaidoService baiDoService;
    
    @GetMapping("/baidos")
    public ResponseEntity<List<Baido>> getBaiDos(){
        return new ResponseEntity<>(this.baiDoService.getBaiDo(null), HttpStatus.OK);
    }
    
    @GetMapping("/baidos/{idBaiDo}/danhgias")
    public ResponseEntity<List<Danhgia>> getDanhGias(@PathVariable(value = "idBaiDo") int id){
        return new ResponseEntity<>(this.baiDoService.getDanhGiaByBaiDo(id), HttpStatus.OK);
    }
}

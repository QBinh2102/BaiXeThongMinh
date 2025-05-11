/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.controllers;

import com.bxtm.pojo.Baido;
import com.bxtm.pojo.Giatien;
import com.bxtm.services.BaidoService;
import com.bxtm.services.GiatienService;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author toquocbinh2102
 */
@Controller
public class baidoController {
    @Autowired
    private BaidoService baiDoService;
    
    @RequestMapping("/baidos")
    public String baido(Model model, @RequestParam Map<String,String> params){
        List<Baido> baidos = this.baiDoService.getBaiDo(params);
        model.addAttribute("baidos", baidos);
        int idLoaiNgay = Integer.parseInt(params.get("idLoaiNgay"));
        model.addAttribute("giaTienMap", this.baiDoService.getBaiDoWithGiaTienByLoaiNgay(baidos, idLoaiNgay));
        
        return "baido";
    }
}

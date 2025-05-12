/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.controllers;

import com.bxtm.pojo.Nguoidung;
import com.bxtm.services.NguoidungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author toquocbinh2102
 */
@Controller
@RequestMapping("/nguoidungs")
public class NguoidungController {
    @Autowired
    private NguoidungService nguoiDungService;
    
    @GetMapping("/")
    public String createView(Model model) {
        model.addAttribute("nguoidung", new Nguoidung());
        return "nguoidungs";
    }
    
    @PostMapping("/add")
    public String add(@ModelAttribute(value = "nguoidung") Nguoidung nguoiDung) {
        this.nguoiDungService.createOrUpdate(nguoiDung);
        
        return "redirect:/nguoidungs";
    } 
    
    @GetMapping("/{idNguoiDung}")
    public String updateView(Model model, @PathVariable(value = "idNguoiDung") int id) {
        model.addAttribute("product", this.nguoiDungService.getNguoiDungById(id));
        return "nguoidungs";
    }
}

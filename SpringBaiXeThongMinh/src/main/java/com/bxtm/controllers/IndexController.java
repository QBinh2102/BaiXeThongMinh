/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author toquocbinh2102
 */
@Controller
public class IndexController {
    
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("baiDo","Bãi đỗ");
        model.addAttribute("msg", "Chào mừng đến với bãi đỗ xe thông minh");
        return "index";
    }
}

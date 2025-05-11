/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.services.impl;

import com.bxtm.pojo.Anhbai;
import com.bxtm.repositories.AnhbaiRepository;
import com.bxtm.services.AnhbaiService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author toquocbinh2102
 */
@Service
public class AnhbaiServiceImpl implements AnhbaiService{
    @Autowired
    private AnhbaiRepository anhBaiRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Anhbai> getAnhBai(Map<String, String> params) {
        return this.anhBaiRepo.getAnhBai(params);
    }

    @Override
    public Anhbai createOrUpdate(Anhbai anhBai) {
        if(!anhBai.getFile().isEmpty()){
            try {
                Map res = cloudinary.uploader().upload(anhBai.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                anhBai.setAnhBai(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(AnhbaiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.anhBaiRepo.createOrUpdate(anhBai);
    }
    
}

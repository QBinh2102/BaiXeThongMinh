/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.formatters;

import com.bxtm.pojo.Loaingay;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author toquocbinh2102
 */
public class LoaingayFormatter implements Formatter<Loaingay>{

    @Override
    public String print(Loaingay ln, Locale locale) {
        return String.valueOf(ln.getId());
    }

    @Override
    public Loaingay parse(String idLoaiNgay, Locale locale) throws ParseException {
        Loaingay ln = new Loaingay();
        ln.setId(Integer.valueOf(idLoaiNgay));
        return ln;
    }
    
}

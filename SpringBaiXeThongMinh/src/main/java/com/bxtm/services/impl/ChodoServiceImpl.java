/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bxtm.services.impl;

import com.bxtm.pojo.Chodo;
import com.bxtm.pojo.Booking;
import com.bxtm.repositories.ChodoRepository;
import com.bxtm.services.BookingService;
import com.bxtm.services.ChodoService;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author toquocbinh2102
 */
@Service
public class ChodoServiceImpl implements ChodoService{
    @Autowired
    private ChodoRepository choDoRepo;
    
    @Autowired
    private BookingService bookingService;

    @Override
    public List<Chodo> getChoDo(Map<String, String> params) {
        return this.choDoRepo.getChoDo(params);
    }

    @Override
    public Chodo createOrUpdate(Chodo choDo) {
        return this.choDoRepo.createOrUpdate(choDo);
    }
    // tạo thêm GetChoDoTrong 
    @Override
    public List<Chodo> getChoDoTrong(Map<String,String> params, LocalDateTime startTime, LocalDateTime endTime)
    {
        
        List<Chodo> choDoByID = this.choDoRepo.getChoDo(params);
        // Goi bookingService ve lay het Booking
        // Lay het booking theo tung choDoByID  ( lay may thang bi dat - ra )
        Map<String,String> paramsBooking = new HashMap();
        
        paramsBooking.put("startTime", String.valueOf(startTime));
        paramsBooking.put("endTime", String.valueOf(endTime));
        List<Booking> bookingDaDat = this.bookingService.getBookings(paramsBooking);
         Set<Integer> choDaBiDatIds = bookingDaDat.stream()
        .map(b -> b.getIdChoDo().getId())
        .collect(Collectors.toSet());

        // B4: Lọc ra các chỗ đỗ chưa bị đặt và đang hoạt động (trạng thái != 'Bảo trì')
        List<Chodo> choDoTrong = choDoByID.stream()
            .filter(cho -> !choDaBiDatIds.contains(cho.getId()) && !"Bảo trì".equalsIgnoreCase(cho.getTrangThai()))
            .collect(Collectors.toList());

        return choDoTrong;
        
    }
}

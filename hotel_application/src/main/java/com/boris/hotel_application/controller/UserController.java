package com.boris.hotel_application.controller;

import com.boris.hotel_application.entity.Hotel;
import com.boris.hotel_application.entity.Room;
import com.boris.hotel_application.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class UserController {

    private HotelService hotelService;

    @Autowired
    public UserController(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    @GetMapping
    public List<Hotel> hotelList(){
        return hotelService.findAll();
    }

    @PostMapping("/admin/saveHotel")
    public Hotel saveHotel(@RequestBody Hotel request){
        return hotelService.save(request);
    }

    @GetMapping("/{findById}")
    public Optional<Hotel> hotelById(@PathVariable Long findById){
        return hotelService.findById(findById);
    }

    @GetMapping("/{hotel_r_id}/rooms")
    public List<Room> availableRoomsInHotel(@PathVariable Long hotel_r_id){
        return hotelService.roomList(hotel_r_id);
    }

    @DeleteMapping("/admin/deleteHotel/{hotelId}")
    public String deleteHotel(@PathVariable Long hotelId){
        hotelService.deleteById(hotelId);
        return "Hotel deleted.";
    }
}

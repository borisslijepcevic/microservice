package com.boris.hotel_application.controller;

import com.boris.hotel_application.entity.Hotel;
import com.boris.hotel_application.entity.Room;
import com.boris.hotel_application.service.HotelService;
import com.boris.hotel_application.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class UserController {

    private HotelService hotelService;
    private RoomService roomService;

    @Autowired
    public UserController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public UserController(HotelService hotelService, RoomService roomService) {
        this.hotelService = hotelService;
        this.roomService = roomService;
    }

    public UserController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Hotel> hotelList(){
        return hotelService.findAll();
    }

    @PostMapping("/admin/saveHotel")
    public Hotel saveHotel(@RequestBody Hotel request){
        return hotelService.save(request);
    }

    @PostMapping("/freeRoomsAll")
    public List<Room> allAvailableRooms(boolean isFree){
        return roomService.findRoomsByIsFree(isFree);
    }
}

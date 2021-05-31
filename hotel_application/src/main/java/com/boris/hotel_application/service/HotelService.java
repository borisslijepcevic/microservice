package com.boris.hotel_application.service;

import com.boris.hotel_application.entity.Hotel;
import com.boris.hotel_application.entity.Room;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    List<Hotel> findAll();
    Optional<Hotel> findById(Long hotel_id) throws RuntimeException;
    Hotel save(Hotel hotel);
    List<Room> roomList(Long hotel_id);
    void deleteById(Long hotel_id);

}

package com.boris.hotel_application.service;

import com.boris.hotel_application.dao.HotelRepository;
import com.boris.hotel_application.entity.Hotel;
import com.boris.hotel_application.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService{

    private HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> findAll() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels;
    }

    public Optional<Hotel> findById(@RequestParam Long hotel_id) throws RuntimeException {
        Optional<Hotel> hotel = hotelRepository.findById(hotel_id);
        if (!hotel.isPresent()){
            throw new RuntimeException("Hotel with " + hotel_id + "not found.");
        }
        return hotel;
    }

    @Override
    public Hotel save(Hotel hotel) {
        boolean hotelExists = hotelRepository.findByEmail(hotel.getEmail()).isPresent();
        if(hotelExists){
            throw new RuntimeException("Hotel already registered.");
        }
        hotelRepository.save(hotel);
        return hotel;
    }

    @Override
    public List<Room> roomList(Long hotel_id) {
        Optional<Hotel> hotel = hotelRepository.findById(hotel_id);
        List<Room> rooms;
        if(hotel.isPresent()){
            rooms = hotel.get().getRoomList();
        } else {
            throw new RuntimeException("Hotel not found.");
        }
        return rooms;
    }

    @Override
    public void deleteById(Long hotel_id) {
        Optional<Hotel> hotel = hotelRepository.findById(hotel_id);
        if(hotel.isPresent()) {
            hotelRepository.deleteById(hotel_id);
        }else {
            throw new RuntimeException("Hotel not found.");
        }
    }
}

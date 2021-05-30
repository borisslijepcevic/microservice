package com.boris.hotel_application.service;

import com.boris.hotel_application.dao.RoomRepository;
import com.boris.hotel_application.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

@Service
public class RoomServiceImpl implements RoomService{

    private RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> findRoomsByIsFree(boolean isFree) {
        Iterator<String> iterator = roomRepository.iterator();
        List<Room> availableRooms = new ArrayList<>();
        while (iterator.hasNext()){
            if(isFree){
                availableRooms.add((Room) iterator);
            }
        }
        return availableRooms;
    }

    @Override
    public List<Room> findRoomsByHotel(Long hotel_r_id) {
        List<Room> hotelRooms = roomRepository.findRoomsByHotel(hotel_r_id);
        return hotelRooms;
    }

    @Override
    public List<Room> findRoomsByHotelAndFree(Long hotel_r_id, boolean isFree) {
        return null;
    }
}

package com.boris.hotel_application.service;

import com.boris.hotel_application.entity.Room;

import java.util.List;

public interface RoomService {

    List<Room> findRoomsByIsFree(boolean isFree);
    List<Room> findRoomsByHotel(Long hotel_r_id);
    List<Room> findRoomsByHotelAndFree(Long hotel_r_id, boolean isFree);
}

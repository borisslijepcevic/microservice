package com.boris.hotel_application.dao;

import com.boris.hotel_application.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findRoomsByFreeIs(boolean isFree);
    List<Room> findRoomsByHotel(Long hotel_r_id);
    List<Room> findRoomsByHotelAndFree(Long hotel_r_id, boolean isFree);

    Iterator<String> iterator();
}

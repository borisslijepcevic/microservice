package com.boris.hotel_application.dao;

import com.boris.hotel_application.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {


    Optional<Hotel> findByEmail(String email);
}

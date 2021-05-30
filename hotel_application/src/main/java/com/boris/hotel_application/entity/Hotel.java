package com.boris.hotel_application.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Hotel {

    @SequenceGenerator(name = "hotel_sequence",
            sequenceName = "hotel_sequence")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "hotel_sequence")
    private Long id;
    
    private String name;

    @Column(unique = true)
    private String email;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_a_id")
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_r_id")
    private List<Room> roomList = new ArrayList<>();

    public Hotel(String name, String email, List<Address> addresses, List<Room> roomList) {
        this.name = name;
        this.email = email;
        this.addresses = addresses;
        this.roomList = roomList;
    }
}

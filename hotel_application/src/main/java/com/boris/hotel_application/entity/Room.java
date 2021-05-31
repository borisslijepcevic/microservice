package com.boris.hotel_application.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Room {

    @SequenceGenerator(name = "room_sequence",
            sequenceName = "room_sequence")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private boolean isFree;

    public Room(String type, boolean isFree) {
        this.type = type;
        this.isFree = isFree;
    }
}

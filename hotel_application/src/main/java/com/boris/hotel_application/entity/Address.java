package com.boris.hotel_application.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Address {

    @SequenceGenerator(name = "address_sequence",
                    sequenceName = "address_sequence",
                    allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "address_sequence")
    private Long id;

    private String streetName;

    private int streetNumber;

    private String town;

    private String state;

    public Address(String streetName, int streetNumber, String town, String state) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.town = town;
        this.state = state;
    }
}

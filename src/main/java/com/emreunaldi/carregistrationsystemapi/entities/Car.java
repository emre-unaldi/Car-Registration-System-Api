package com.emreunaldi.carregistrationsystemapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name="plaque")
    private String plaque;

    @Column(name = "model")
    private String model;

    @Column(name = "brand")
    private String brand;

    @Column(name = "year")
    private int year;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name="FK_CARS_USERS"))
    private User user;
}

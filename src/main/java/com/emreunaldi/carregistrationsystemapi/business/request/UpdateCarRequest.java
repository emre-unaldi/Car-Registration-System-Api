package com.emreunaldi.carregistrationsystemapi.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
    private int id;
    private String name;
    private String plaque;
    private String model;
    private String brand;
    private int year;

    private int userId;
}

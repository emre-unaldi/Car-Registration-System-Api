package com.emreunaldi.carregistrationsystemapi.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponse {
    private int id;
    private String name;
    private String plaque;
    private String model;
    private String brand;
    private int year;
    private String userFirstName;
    private String userLastName;

}

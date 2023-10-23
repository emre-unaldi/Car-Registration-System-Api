package com.emreunaldi.carregistrationsystemapi.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    List<GetCarResponse> cars;
}

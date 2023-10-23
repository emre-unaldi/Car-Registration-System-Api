package com.emreunaldi.carregistrationsystemapi.utilities.results;

import lombok.Data;

@Data
public class Result {
    private Boolean success;
    private String message;

    public Result(Boolean success){
        this.success=success;
    }

    public Result(String message){
        this.message=message;
    }

    public Result(Boolean success, String message){
        this.success=success;
        this.message=message;
    }
}

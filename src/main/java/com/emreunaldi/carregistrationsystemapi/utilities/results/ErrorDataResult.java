package com.emreunaldi.carregistrationsystemapi.utilities.results;

public class ErrorDataResult <T> extends DataResult<T>{
    public ErrorDataResult(){
        super(false,null);
    }

    public ErrorDataResult(String message){
        super(false,message,null);
    }
}

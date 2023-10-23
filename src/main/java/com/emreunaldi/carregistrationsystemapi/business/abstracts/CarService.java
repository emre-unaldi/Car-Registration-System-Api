package com.emreunaldi.carregistrationsystemapi.business.abstracts;

import com.emreunaldi.carregistrationsystemapi.business.request.AddCarRequest;
import com.emreunaldi.carregistrationsystemapi.business.request.UpdateCarRequest;
import com.emreunaldi.carregistrationsystemapi.business.response.GetCarResponse;
import com.emreunaldi.carregistrationsystemapi.entities.Car;
import com.emreunaldi.carregistrationsystemapi.utilities.results.DataResult;
import com.emreunaldi.carregistrationsystemapi.utilities.results.Result;

import java.util.List;

public interface CarService {
     DataResult<AddCarRequest> add(AddCarRequest addCarRequest);
     Result delete(int id);
     DataResult<Car> update(UpdateCarRequest updateCarRequest);
     DataResult<List<GetCarResponse>> getAll();
     DataResult<List<GetCarResponse>> getCarByUserId(int id);
     DataResult<GetCarResponse> getCarById(int id);
}

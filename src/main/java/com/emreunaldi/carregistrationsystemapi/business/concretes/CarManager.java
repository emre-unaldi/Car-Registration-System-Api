package com.emreunaldi.carregistrationsystemapi.business.concretes;

import com.emreunaldi.carregistrationsystemapi.business.abstracts.CarService;
import com.emreunaldi.carregistrationsystemapi.business.request.AddCarRequest;
import com.emreunaldi.carregistrationsystemapi.business.request.UpdateCarRequest;
import com.emreunaldi.carregistrationsystemapi.business.response.GetCarResponse;
import com.emreunaldi.carregistrationsystemapi.dataAccess.CarRepository;
import com.emreunaldi.carregistrationsystemapi.entities.Car;
import com.emreunaldi.carregistrationsystemapi.utilities.mappers.ModelMapperService;
import com.emreunaldi.carregistrationsystemapi.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarManager implements CarService {

    CarRepository _carRepository;
    ModelMapperService _modelMapperService;


    @Autowired
    public CarManager(CarRepository carRepository, ModelMapperService modelMapperService){
        this._carRepository=carRepository;
        this._modelMapperService=modelMapperService;
    }

    @Override
    public DataResult<AddCarRequest> add(AddCarRequest addCarRequest) {
        try {
            Car car= this._modelMapperService.forRequest().map(addCarRequest, Car.class);
            this._carRepository.save(car);
            addCarRequest= this._modelMapperService.forResponse().map(car,AddCarRequest.class);
            return new SuccessDataResult<>(addCarRequest,"Success");
        }catch (Exception error){
            return new ErrorDataResult<>(error.getMessage());
        }
    }

    @Override
    public Result delete(int id) {
        try {
            this._carRepository.deleteById(id);
            return new SuccessResult("Success");
        }catch (Exception error){
            return new ErrorResult(error.getMessage());
        }
    }

    @Override
    public DataResult<Car> update(UpdateCarRequest updateCarRequest) {
        try{
            Car car= this._modelMapperService.forRequest().map(updateCarRequest, Car.class);
            this._carRepository.save(car);
            return new SuccessDataResult<>(car,"Success");
        }catch (Exception error){
            return new ErrorDataResult<>(error.getMessage());
        }
    }

    @Override
    public DataResult<List<GetCarResponse>> getAll() {
        try{
            List<Car> carList= this._carRepository.findAll();
            List<GetCarResponse> getCarResponseList=carList.stream().map(car -> this._modelMapperService.forResponse().map(car,GetCarResponse.class)).toList();
            return new SuccessDataResult<>(getCarResponseList,"Success");
        }catch(Exception error){
            return new ErrorDataResult<>(error.getMessage());
        }
    }

    @Override
    public DataResult<List<GetCarResponse>> getCarByUserId(int id) {
        try{
            List<Car> carList= this._carRepository.getCarByUserId(id);
            List<GetCarResponse> getCarResponseList= carList.stream().map(car -> this._modelMapperService.forResponse().map(car,GetCarResponse.class)).toList();
            return new SuccessDataResult<>(getCarResponseList,"Success");
        }catch (Exception error){
            return new ErrorDataResult<>(error.getMessage());
        }
    }

    @Override
    public DataResult<GetCarResponse> getCarById(int id) {
        try{
            Car car=this._carRepository.findById(id).orElseThrow();
            GetCarResponse getCarResponse= this._modelMapperService.forResponse().map(car, GetCarResponse.class);
            return new SuccessDataResult<>(getCarResponse,"Success");
        }catch (Exception error){
            return new ErrorDataResult<>(error.getMessage());
        }
    }
}

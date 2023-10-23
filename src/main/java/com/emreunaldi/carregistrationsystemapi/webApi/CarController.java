package com.emreunaldi.carregistrationsystemapi.webApi;

import com.emreunaldi.carregistrationsystemapi.business.abstracts.CarService;
import com.emreunaldi.carregistrationsystemapi.business.request.AddCarRequest;
import com.emreunaldi.carregistrationsystemapi.business.request.UpdateCarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class CarController {
    CarService _carService;

    @Autowired
    public CarController(CarService _carService) {
        this._carService = _carService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody AddCarRequest addCarRequest){
        return ResponseEntity.ok(this._carService.add(addCarRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id){
        return ResponseEntity.ok(this._carService.delete(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody UpdateCarRequest updateCarRequest){
        return ResponseEntity.ok(this._carService.update(updateCarRequest));
    }

    @GetMapping("/getall")
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.ok(this._carService.getAll());
    }

    @GetMapping("/getcarbyid/{id}")
    public ResponseEntity<Object> getCarById(@PathVariable int id){
        return ResponseEntity.ok(this._carService.getCarById(id));
    }

    @GetMapping("/getcarbyuserid/{id}")
    public ResponseEntity<Object> getCarByUserId(@PathVariable int id){
        return ResponseEntity.ok(this._carService.getCarByUserId(id));
    }
}

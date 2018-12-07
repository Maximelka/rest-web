package nc.rest.controller;

import nc.rest.model.Car;
import nc.rest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/car", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/{carId:\\d+}")
    public Car getCar(@PathVariable int carId) {
        return carService.getCar(carId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProfile(@Valid @RequestBody CarRequest request) {
        carService.createCar(
                request.getName(),
                request.getMarka(),
                request.getYear()
        );
    }
}


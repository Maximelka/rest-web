package nc.rest.service;

import nc.rest.model.Car;

public interface CarService {

    Car getCar(int carId);
    void createCar(String name, String marka, int year);
}

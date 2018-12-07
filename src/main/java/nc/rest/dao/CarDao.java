package nc.rest.dao;

import nc.rest.model.Car;

import java.util.Optional;

public interface CarDao {

    Optional<Car> getCarById(int id);
    void insertCar(String name, String marka, int year);
    void updateCar(String name, String marka, int year, int id);
    void deleteCarById(int id);
}

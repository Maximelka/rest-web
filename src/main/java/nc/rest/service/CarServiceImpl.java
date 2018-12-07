package nc.rest.service;

import nc.rest.dao.CarDao;
import nc.rest.exception.CarNotFoundException;
import nc.rest.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    @Autowired
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public Car getCar(int carId) {
        return carDao.getCarById(carId)
                .orElseThrow(() -> new CarNotFoundException(carId));
    }

    @Override
    public void createCar(String name, String marka, int year) {
        carDao.insertCar(name,marka,year);
    }

    @Override
    public void updateCar(String name, String marka, int year, int id) {
        Car car = carDao.getCarById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
        carDao.updateCar(name, marka, year, car.getId());
    }

    @Override
    public void deleteCar(int id) {
        Car profile = carDao.getCarById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
        carDao.deleteCarById(profile.getId());
    }
}

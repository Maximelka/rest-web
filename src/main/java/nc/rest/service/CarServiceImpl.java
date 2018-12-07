package nc.rest.service;

import nc.rest.dao.CarDao;
import nc.rest.exception.CarNotFoundException;
import nc.rest.model.Car;
import org.springframework.beans.factory.annotation.Autowired;

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
}

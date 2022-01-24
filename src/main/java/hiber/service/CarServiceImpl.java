package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.CarDaoImp;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarDao carDao;

    @Transactional
    @Override
    public void addCar(Car car) {
        carDao.addCar(car);
    }
    @Transactional
    @Override
    public List<Car> listCars() {
        return carDao.listCars();
    }
}

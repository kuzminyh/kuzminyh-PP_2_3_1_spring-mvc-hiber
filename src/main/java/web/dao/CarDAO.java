package web.dao;
import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;


    @Repository
    public class CarDAO {
        private static int id_car;
        private List<Car> cars;

        {
            cars = new ArrayList<>();

            cars.add(new Car(++id_car, "ziguli"));
            cars.add(new Car(++id_car, "renault"));
            cars.add(new Car(++id_car, "luaz"));
            cars.add(new Car(++id_car, "lada"));
            cars.add(new Car(++id_car, "UAZ"));
            cars.add(new Car(++id_car, "toyota"));
        }

        public List<Car> getAllCars() {
            return cars;
        }

        public Car get(int id) {
            return cars.stream().filter(car -> car.getId() == id).findFirst().orElse(null);
        }

        public void save(Car car) {
            car.setId(++id_car);
            cars.add(car);
        }

        public void update(int id, Car car) {
            Car old = get(id);
            old.setModel(car.getModel());
        }

        public void delete(int id) {
            cars.removeIf(car -> car.getId() == id);
        }
    }


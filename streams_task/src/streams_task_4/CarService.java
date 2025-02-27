package streams_task_4;

import java.util.List;
import java.util.Set;

public interface CarService {
    // Calculate the sum of all car prices
    double sumOfPrices(List<Car> carList);

    // Get the names of all cars
    List<String> getCarNames(List<Car> carList);

    // Get unique car manufacturers
    Set<String> getCarMakers(List<Car> carList);

    // Get the highest car price
    double getHighPricedCar(List<Car> carList);

    // Get the car with the lowest price
    Car getCarWithLowPricedCar(List<Car> carList);
}

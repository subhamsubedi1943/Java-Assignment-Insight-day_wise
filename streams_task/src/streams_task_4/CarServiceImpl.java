package streams_task_4;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {

    // Calculate the total sum of car prices
    @Override
    public double sumOfPrices(List<Car> carList) {
        return carList.stream()
                .mapToDouble(Car::getPrice) // Extracts prices and sums them
                .sum();
    }

    // Retrieve the list of car names
    @Override
    public List<String> getCarNames(List<Car> carList) {
        return carList.stream()
                .map(Car::getCarName) // Extract car names
                .collect(Collectors.toList());
    }

    // Get unique car makers
    @Override
    public Set<String> getCarMakers(List<Car> carList) {
        return carList.stream()
                .map(Car::getCarMake) // Extract car manufacturers
                .collect(Collectors.toSet());
    }

    // Get the highest priced car's price
    @Override
    public double getHighPricedCar(List<Car> carList) {
        return carList.stream()
                .mapToDouble(Car::getPrice) // Extract prices
                .max() // Get the highest price
                .orElse(0.0);
    }

    // Get the car with the lowest price
    @Override
    public Car getCarWithLowPricedCar(List<Car> carList) {
        return carList.stream()
                .min((car1, car2) -> Double.compare(car1.getPrice(), car2.getPrice())) // Find the car with the lowest price
                .orElse(null);
    }
}

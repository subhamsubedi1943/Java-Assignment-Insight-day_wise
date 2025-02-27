package streams_task_4;
import java.util.*;

public class CarApp {
    public static void main(String[] args) {
        // Creating a list of cars
        List<Car> carList = Arrays.asList(
                new Car("Maruti", "Swift Dezire", 810000.00),
                new Car("Hyundai", "Verna", 1100000.00),
                new Car("Toyota", "Innova", 2450000.00),
                new Car("Audi", "Q3", 4500000.00)
        );

        // Creating service instance
        CarService carService = new CarServiceImpl();

        try {
            // Calling service methods
            System.out.println("Total Price of Cars: " + carService.sumOfPrices(carList));
            System.out.println("Car Names: " + carService.getCarNames(carList));
            System.out.println("Unique Car Makers: " + carService.getCarMakers(carList));
            System.out.println("Highest Priced Car: " + carService.getHighPricedCar(carList));
            System.out.println("Car with Lowest Price: " + carService.getCarWithLowPricedCar(carList));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
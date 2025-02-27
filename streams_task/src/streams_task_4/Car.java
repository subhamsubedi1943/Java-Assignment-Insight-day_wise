package streams_task_4;

public class Car {
    private String carMake; // e.g., Maruti
    private String carName; // e.g., Swift Dezire
    private double price;   // e.g., 812000.0

    public Car() {}

    public Car(String carMake, String carName, double price) {
        this.carMake = carMake;
        this.carName = carName;
        this.price = price;
    }

    public String getCarMake() { return carMake; }
    public String getCarName() { return carName; }
    public double getPrice() { return price; }

    public void setCarMake(String carMake) { this.carMake = carMake; }
    public void setCarName(String carName) { this.carName = carName; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Car [Car Make=" + carMake + ", Car Name=" + carName + ", Price=" + price + "]";
    }
}

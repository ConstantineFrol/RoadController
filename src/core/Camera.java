package core;

public class Camera
{
    public static Car getNextCar()
    {
        // String randomNumber
        String randomNumber = Double.toString(Math.random()).substring(2, 5);
        // int randomHeight
        int randomHeight = (int) (1000 + 3500. * Math.random());
        // int randomWeight
        double randomWeight = 600 + 10000 * Math.random();
        // Car car - Object
        Car car = new Car();
        car.number = randomNumber;
        car.height = randomHeight;
        car.weight = randomWeight;
        car.hasVehicle = Math.random() > 0.5;
        car.isSpecial = Math.random() < 0.15;

        return car;
    }
}
import core.*;
import core.Camera;

import java.util.Scanner;

public class RoadController {
    // GLOBAL VARIABLES
    // double passengerCarMaxWeight
    private static double passengerCarMaxWeight = 3500.0; // kg
    // int passengerCarMaxHeight
    private static int passengerCarMaxHeight = 2000; // mm
    // int controllerMaxHeight
    private static int controllerMaxHeight = 3500; // mm
    // int passengerCarPrice
    private static int passengerCarPrice = 100; // RUB
    // int cargoCarPrice
    private static int cargoCarPrice = 250; // RUB
    // int vehicleAdditionalPrice
    private static int vehicleAdditionalPrice = 200; // RUB

    public static void main(String[] args) {
        System.out.println("Сколько автомобилей сгенерировать?");

        // Scanner scanner
        Scanner scanner = new Scanner(System.in);
        //int carsCount
        int carsCount = scanner.nextInt();
        // int i
        for (int i = 0; i < carsCount; i++) {
            // Car car - Object
            Car car = Camera.getNextCar();
            System.out.println(car);

            //Пропускаем автомобили спецтранспорта бесплатно
            if (car.isSpecial) {
                openWay();
                continue;
            }

            //Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
            // int price
            int price = calculatePrice(car);
            if (price == -1) {
                continue;
            }

            System.out.println("Общая сумма к оплате: " + price + " руб.");
        }
    }

    /**
     * Расчёт стоимости проезда исходя из массы и высоты
     */
    private static int calculatePrice(Car car) {
        // int carHeight
        int carHeight = car.height;
        // int price
        int price = 0;
        // Comparing controller and vehicle by height
        if (carHeight > controllerMaxHeight) {
            blockWay("высота вашего ТС превышает высоту пропускного пункта!");
            return -1;
            // If vehicle passing Controller then:
        } else {
            // Check vehicle HEIGHT
            if (carHeight > passengerCarMaxHeight) {
                // Get Weight of the vehicle
                double weight = car.weight;
                //Грузовой автомобиль
                if (weight > passengerCarMaxWeight) {
                    // Charge as Cargo vehicle
                    price = cargoCarPrice;
                    // Check for trailer
                    if (car.hasVehicle) {
                        // Add extra charge
                        price = price + vehicleAdditionalPrice;
                    }
                }
                // WEIGHT < passengerCarMaxWeight
                //Легковой автомобиль
                else {
                    // charge as passenger vehicle
                    price = passengerCarPrice;
                }
                // If carHeight < passengerCarMaxHeight
            } else {
                // charge as passenger vehicle
                price = passengerCarPrice;
            }
        }
        return price;
    }

    /**
     * Открытие шлагбаума
     */
    private static void openWay() {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    /**
     * Сообщение о невозможности проезда
     */
    private static void blockWay(String reason) {
        System.out.println("Проезд невозможен: " + reason);
    }
}
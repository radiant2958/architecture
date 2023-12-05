package ru.geekbrains.lesson3;

import java.awt.*;

public class Program {


    public static void main(String[] args) {
        // SportCar sportCar = SportCar.create("A", "B", Color.BLACK, 3);
        // RefuelingStation refuelingStation = new RefuelingStation();
        // sportCar.setRefuelingStation(refuelingStation);
        // sportCar.fuel();
        Car sedan = new Sedan("Toyota", "Camry", Color.WHITE);
        SportCar sportCar = SportCar.create("Ferrari", "458 Italia", Color.RED,4);

        
        RefuelingStation refuelingStation2 = new RefuelingStation();
        CarWashService carWashService = new CarWashService();

        
        sedan.setRefuelingStation(refuelingStation2);
        sportCar.setRefuelingStation(refuelingStation2);

        sedan.setCarWashService(carWashService);
        sportCar.setCarWashService(carWashService);

        
        sedan.fuel();
        sedan.washCar(CarWashType.ServingWash);

    

        sportCar.fuel();
        sportCar.washCar(CarWashType.SelfWash);

    }

    // public static double calculateMaintenance(Car car){
    //     if (car.getWheelsCount() == 6){
    //         return 1500 * 6;
    //     }
    //     else {
    //         return 1000 * 4;
    //     }
    // }

}

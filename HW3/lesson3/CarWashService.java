package ru.geekbrains.lesson3;

public class CarWashService implements CarWash {

    @Override
    public void wash(CarWashType carWashType) {
        switch (carWashType) {
            case SelfWash -> System.out.println("Вы помыли машину самостоятельно");
            case ServingWash -> System.out.println("Вашу машину помыли");   
                
        }
    }
    
}

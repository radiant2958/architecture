package ru.geekbrains.lesson3;

import java.awt.Color;

public class Sedan extends Car {

    public Sedan(String make, String model, Color color) {
        super(make, model, color);
        
    }

    @Override
    public void movement() {
        System.out.println("Седан движется по дороге.");
    }

    @Override
    public void maintenance() {
        System.out.println("Обслуживание седана проведено.");

         
    }

    @Override
    public boolean gearShifting() {
        System.out.println("Переключение передач в седане.");
        return true; 
    }

    @Override
    public boolean switchHeadlights() {
        System.out.println("Фары включены в седане.");
        return true; 
    }

    @Override
    public boolean switchWipers() {
        System.out.println("Дворники включены в седане.");
        return true; 
    }
}
    


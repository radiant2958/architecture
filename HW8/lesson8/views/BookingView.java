package ru.geekbrains.lesson8.views;

import ru.geekbrains.lesson8.models.Reservation;
import ru.geekbrains.lesson8.models.Table;
import ru.geekbrains.lesson8.presenters.View;
import ru.geekbrains.lesson8.presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


public class BookingView implements View {

    private Collection<ViewObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(ViewObserver observer) {
        observers.add(observer);
    }

    public void showTables(Collection<Table> tables){
        for (Table table: tables) {
            System.out.println(table);
        }
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0)
            System.out.printf("Столик успешно забронирован. Номер вашей брони: #%d\n", reservationNo);
        else
            System.out.println("Не удалось забронировать столик. Повторите попытку позже.");

    }

    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        for (ViewObserver observer : observers) {
            observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);
        }
    }
    



    

    public void reservationTable(Date orderDate, int tableNo, String name){
        for (ViewObserver observer : observers){
            observer.onReservationTable(orderDate, tableNo, name);
        }
    }

    @Override
    public void showAllReservations(Collection<Reservation> reservations) {
        if (reservations.isEmpty()) {
            System.out.println("Нет активных бронирований.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.printf("Бронь #%d: Столик #%d на имя %s, Дата: %s\n",
                    reservation.getId(),
                    reservation.getTable().getNo(),
                    reservation.getName(),
                    reservation.getDate().toString());
            }
        }
    }

}

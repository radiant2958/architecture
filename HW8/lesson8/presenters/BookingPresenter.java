package ru.geekbrains.lesson8.presenters;

import java.util.Collection;
import java.util.Date;

import ru.geekbrains.lesson8.models.Reservation;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }

    public void updateUILoadTables(){
        view.showTables(model.loadTables());
    }

    public void updateUIReservationTableResult(int reservationNo){
        view.showReservationTableResult(reservationNo);
    }
    
    public void showAllReservations() {
        Collection<Reservation> reservations = model.getAllReservations();
        view.showAllReservations(reservations);
    }


    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateUIReservationTableResult(reservationNo);
        }
        catch (Exception e){
            updateUIReservationTableResult(-1);
        }
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        try {
            int newReservationId = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
            updateUIReservationTableResult(newReservationId);
        } catch (Exception e) {
            updateUIReservationTableResult(-1);
        }
    }
}

package ru.geekbrains.lesson8.presenters;

import ru.geekbrains.lesson8.models.Reservation;
import ru.geekbrains.lesson8.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    Collection<Table> loadTables();

    int reservationTable(Date reservationDate, int tableNo, String name);
    
    Collection<Reservation> getAllReservations();
    
    int changeReservationTable(int oldReservationId, Date newReservationDate, int newTableNo, String newName);


}

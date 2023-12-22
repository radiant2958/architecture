package ru.geekbrains.lesson8.models;

import ru.geekbrains.lesson8.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;



public class TableService implements Model {

    private Collection<Table> tables;

    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {

        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }

    public int changeReservationTable(int oldReservationId, Date newReservationDate, int newTableNo, String newName) {
        Reservation oldReservation = null;
        Table oldTable = null;
    
        // Поиск существующей брони
        for (Table table : tables) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == oldReservationId) {
                    oldReservation = reservation;
                    oldTable = table;
                    break;
                }
            }
            if (oldReservation != null) {
                oldTable.getReservations().remove(oldReservation);
                break;
            }
        }
    
        if (oldReservation == null) {
            throw new RuntimeException("Бронь не найдена.");
        }
    
        // Создание новой брони
        return reservationTable(newReservationDate, newTableNo, newName);
    }

    @Override
    public Collection<Reservation> getAllReservations() {
            List<Reservation> allReservations = new ArrayList<>();
            for (Table table : tables) {
                allReservations.addAll(table.getReservations());
            }
            return allReservations;
    }

    
}
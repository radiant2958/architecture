package ru.geekbrains.lesson4.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TicketProvider {

    private final Database database;
    private final PaymentProvider paymentProvider;

    public TicketProvider(Database database, PaymentProvider paymentProvider){
        assert database != null : "База данных не может быть null";
        assert paymentProvider != null : "PaymentProvider не может быть null";
        this.database = database;
        this.paymentProvider = paymentProvider;
    }

    public Collection<Ticket> searchTicket(int clientId, Date date){
        assert clientId > 0 : "Недопустимый идентификатор клиента";
        assert date != null : "Дата не может быть null";

        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket: database.getTickets()) {
            if (ticket.getCustomerId() == clientId && ticket.getDate().equals(date))
                tickets.add(ticket);
        }

        assert tickets != null : "Коллекция билетов не может быть null";
        return tickets;
    }

    public boolean buyTicket(int clientId, String cardNo){
        assert clientId > 0 : "Недопустимый идентификатор клиента";
        assert cardNo != null && !cardNo.isEmpty() : "Номер карты не может быть null или пустым";

        int orderId = database.createTicketOrder(clientId);
        double amount = database.getTicketAmount();
        boolean result = paymentProvider.buyTicket(orderId, cardNo, amount);

        assert result : "Покупка билета не удалась";
        return result;
    }

    public boolean checkTicket(String qrcode){
        assert qrcode != null && !qrcode.isEmpty() : "QR-код не может быть null или пустым";

        for (Ticket ticket: database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)){
                ticket.setEnable(false);
                return true;
            }
        }
        return false;
    }
}


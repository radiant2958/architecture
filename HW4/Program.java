package ru.geekbrains.lesson4.task2;

import java.util.Collection;
import java.util.Date;

public class Program {

    /**
     * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус в час пик".
     * @param args
     */
    public static void main(String[] args) {

        // Core core = new Core();

        // MobileApp mobileApp = new MobileApp(core.getTicketProvider(), core.getCustomerProvider());

        // BusStation busStation = new BusStation(core.getTicketProvider());


        // mobileApp.buyTicket("1000000000001");
        // mobileApp.searchTicket(new Date());
        // Collection<Ticket> tickets = mobileApp.getTickets();

        // busStation.checkTicket("AAA");

        Core core = new Core();

        // Создаем приложения для разных пользователей
        MobileApp app1 = new MobileApp(core.getTicketProvider(), core.getCustomerProvider());
        MobileApp app2 = new MobileApp(core.getTicketProvider(), core.getCustomerProvider());

        // Покупка билетов разными пользователями
        app1.buyTicket("1234567890123");
        app2.buyTicket("9876543210987");

        // Поиск билетов
        app1.searchTicket(new Date());
        app2.searchTicket(new Date());

        // Получаем билеты для каждого пользователя
        Collection<Ticket> ticketsApp1 = app1.getTickets();
        Collection<Ticket> ticketsApp2 = app2.getTickets();
        

        // Создаем автобусную станцию
        BusStation busStation = new BusStation(core.getTicketProvider());

        // Проверяем билеты на станции
        for (Ticket ticket : ticketsApp1) {
            boolean isValid = busStation.checkTicket(ticket.getQrcode());
            System.out.println("Ticket " + ticket.getId() + " is " + (isValid ? "valid" : "invalid"));
        }

        for (Ticket ticket : ticketsApp2) {
            boolean isValid = busStation.checkTicket(ticket.getQrcode());
            System.out.println("Ticket " + ticket.getId() + " is " + (isValid ? "valid" : "invalid"));
        }


    }

}

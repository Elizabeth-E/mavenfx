package nl.inholland.javafx.dal.repository;

import nl.inholland.javafx.models.Ticket;
import nl.inholland.javafx.dal.Database;

import java.util.List;

public class TicketRepository {
    private final Database database;

    public TicketRepository(Database database) {
        this.database = database;
    }

    public void create(double price) {
        Ticket ticket = new Ticket(price);

        List<Ticket> tickets = database.getTickets();
        tickets.add(ticket);

        database.setTickets(tickets);
    }

    public Ticket read() {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    public List<Ticket> readAll() {
        return database.getTickets();
    }

    public void update(Ticket oldTicket, Ticket updatedTicket) {
        List<Ticket> tickets = database.getTickets();

        // Find Ticket index
        int ticketIndex ;
        for (ticketIndex = 0; ticketIndex < tickets.size(); ticketIndex++) {
            if (tickets.get(ticketIndex).equals(oldTicket)) {
                break;
            }
        }

        database.getTickets().set(ticketIndex, updatedTicket);
    }

    public void delete(Ticket tick) {
        database.getTickets().remove(tick);
    }

    public void deleteAll() {
        database.getTickets().clear();
    }
}

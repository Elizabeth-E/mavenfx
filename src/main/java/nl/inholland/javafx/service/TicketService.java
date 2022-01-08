package nl.inholland.javafx.service;

import nl.inholland.javafx.dal.Database;
import nl.inholland.javafx.dal.repository.TicketRepository;
import nl.inholland.javafx.models.Ticket;

import java.util.List;

public class TicketService {
    private final Database database;
    private final TicketRepository ticketRepository;

    public TicketService(Database database) {
        this.database = database;
        ticketRepository = new TicketRepository(this.database);
    }

    public void create(double price) {
        ticketRepository.create(price);
    }

    public List<Ticket> readAll() {
        return ticketRepository.readAll();
    }

    public void update(Ticket oldTicket, Ticket updatedTicket) {
        ticketRepository.update(oldTicket, updatedTicket);
    }

    public void delete(Ticket ticket) {
        ticketRepository.delete(ticket);
    }

    public void deleteAll() {
        ticketRepository.deleteAll();
    }
}

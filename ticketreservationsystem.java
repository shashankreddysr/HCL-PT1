import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Ticket {
    private int ticketNumber;
    private String passengerName;
    private String destination;

    public Ticket(int ticketNumber, String passengerName, String destination) {
        this.ticketNumber = ticketNumber;
        this.passengerName = passengerName;
        this.destination = destination;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Ticket #" + ticketNumber + " | Passenger: " + passengerName + " | Destination: " + destination;
    }
}

class ReservationSystem {
    private List<Ticket> tickets = new ArrayList<>();
    private int ticketCounter = 1;

    public void reserveTicket(String passengerName, String destination) {
        Ticket ticket = new Ticket(ticketCounter++, passengerName, destination);
        tickets.add(ticket);
        System.out.println("Ticket reserved: " + ticket);
    }

    public void cancelTicket(int ticketNumber) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketNumber() == ticketNumber) {
                tickets.remove(ticket);
                System.out.println("Ticket canceled: " + ticket);
                return;
            }
        }
        System.out.println("Ticket with number " + ticketNumber + " not found.");
    }

    public void displayTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets reserved.");
        } else {
            System.out.println("Reserved Tickets:");
            for (Ticket ticket : tickets) {
                System.out.println(ticket);
            }
        }
    }
}
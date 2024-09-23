package homework;

import homework.user.Admin;
import homework.user.Client;
import homework.user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TicketService {
    static List<ConcertTicket> tickets = new ArrayList<>();

    public static void main(String[] args) {
        final String phoneNumber = "37577777777";
        final String email = "useremail@gmail.com";

        generateTickets(10);
        Random random = new Random();
        int ticketId = random.nextInt(10) + 1;

        User client = new Client(1);
        User admin = new Admin(1);
        client.printRole();
        admin.printRole();

        ConcertTicket actualTicket = ((Client) client).getTicket();
        System.out.println("Client's ticket: " + actualTicket);
        System.out.println("Is the ticket actual? " + ((Admin) admin).checkTicket(actualTicket));

        ConcertTicket ticketForCheck = tickets.get(ticketId);
        ticketForCheck.shared(phoneNumber);
        ticketForCheck.shared(phoneNumber, email);

        System.out.println(ticketForCheck);
        System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
        TicketService ticketService = new TicketService();
        List<BusTicket> tickets = ticketService.createTicketList();


        TicketValidator validator = new TicketValidator();
        int validTickets = 0;

        for (BusTicket ticket : tickets) {
            List<Integer> violationCount = validator.checkTicket(ticket);
            if (violationCount.isEmpty()) {
                validTickets++;
            }
        }
        System.out.println("Total: " + tickets.size());
        System.out.println("Valid: " + validTickets);
        validator.printViolation();



    }

    public static void generateTickets(int numberOfTickets) {
        Sector sector;
        int count = 1;

        for (int i = 1; i <= numberOfTickets; i++) {
            if (i % 2 == 0) {
                sector = Sector.A;
            } else if (i % 5 == 0) {
                sector = Sector.B;
            } else {
                sector = Sector.C;
            }

            int id = count;
            ConcertTicket ticket = new ConcertTicket(id, "LaScala", (i + 100), true, sector, 10.0f, 9.99);
            count++;
            tickets.add(ticket);
        }
    }

    public static ConcertTicket getTicketById(int id) {
        for (ConcertTicket ticket : tickets) {
            if (id == ticket.getId()) {
                return ticket;
            }
        }
        return null;

    }

    public static List<ConcertTicket> getTicketBySector(Sector sector) {
        List<ConcertTicket> ticketsBySector = new ArrayList<>();
        for (ConcertTicket ticket : tickets) {
            if (sector.equals(ticket.getSector())) {
                ticketsBySector.add(ticket);
            }
        }
        return ticketsBySector;
    }

    private List<BusTicket> createTicketList(){
        List<BusTicket> tickets = new ArrayList<>();

        tickets.add(new BusTicket(TicketClass.CLA, TicketType.DAY, LocalDate.parse("2025-01-01"), 0));
        tickets.add(new BusTicket(TicketClass.CLA, TicketType.DAY, LocalDate.parse("2025-01-01"), 10));
        tickets.add(new BusTicket(TicketClass.CLA, null, null, 1000));
        tickets.add(new BusTicket(TicketClass.STD, TicketType.DAY, LocalDate.parse("2025-01-01"), 0));
        tickets.add(new BusTicket(TicketClass.STD, TicketType.WEEK, LocalDate.parse("2020-01-01"), 50));
        tickets.add(new BusTicket(TicketClass.CLA, TicketType.YEAR, LocalDate.parse("2020-01-01"), 500));
        tickets.add(new BusTicket(TicketClass.CLA, TicketType.MONTH, LocalDate.parse("2020-01-01"), 100));
        tickets.add(new BusTicket(TicketClass.CLA, TicketType.DAY, LocalDate.parse("2020-01-01"), 100));
        tickets.add(new BusTicket(null, TicketType.MONTH, LocalDate.parse("2020-01-01"), 100));
        tickets.add(new BusTicket(TicketClass.STD, TicketType.MONTH, LocalDate.parse("2020-01-01"), 100));
        tickets.add(new BusTicket(TicketClass.STD, null, LocalDate.parse("2020-01-01"), 1000));
        tickets.add(new BusTicket(TicketClass.STD, TicketType.YEAR, LocalDate.parse("2020 -01-01"), 100));
        tickets.add(new BusTicket(TicketClass.CLA, TicketType.MONTH, LocalDate.parse("2020-01-01"), 99));
        tickets.add(new BusTicket(TicketClass.STD, null,  LocalDate.parse("2020-01-01"), 0));
        tickets.add(new BusTicket(TicketClass.CLA, TicketType.YEAR, null, 100));
        tickets.add(new BusTicket(TicketClass.STD, TicketType.DAY, LocalDate.parse("2028-01-01"), 100));
        tickets.add(new BusTicket(TicketClass.CLA, TicketType.DAY,  null, 0));

        return tickets;
    }
}

package homework4;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class TicketValidator1 {
    private static int trueTickets = 0;
    private static int falseTicketType = 0;
    private static int falseTicketDate = 0;
    private static int falseTicketPrice = 0;

    public boolean checkTicket(BusTicket busTicket) {
        Field[] fields = busTicket.getClass().getDeclaredFields();
        for (Field field : fields) {
            checkTicketType(field, busTicket);
            checkStartDate(field, busTicket);
            checkTicketPrice(field, busTicket);


        System.out.println("Ticket is ok");
        trueTickets++;
        System.out.println("Number of valid tickets: " + trueTickets);

        }
        return true;
    }

    private static boolean checkTicketType(Field field, BusTicket busTicket) {
        if (field.getName().equals("ticketType")) {
            field.setAccessible(true);
            String ticketType = busTicket.getTicketType();

            try {
                if (!(ticketType.equals("DAY") || ticketType.equals("WEEK") || ticketType.equals("MONTH") ||
                      ticketType.equals("YEAR"))) {
                    System.out.println("Unacceptable ticket type");
                    falseTicketType++;
                    System.out.println("False ticket type " + falseTicketType);
                    return false;
                }
            } catch (NullPointerException e) {
                System.out.println("Ticket type null");

                falseTicketType++;
                System.out.println("False ticket type " + falseTicketType);
                return false;

            }
            if (ticketType.equals("MONTH")) {
                LocalDate startDate = busTicket.getStartDate();
                if (startDate != null) {
                    System.out.println("This ticket shouldn't have start date");
                    falseTicketDate++;
                    System.out.println("False ticket date" + falseTicketDate);
                    return false;
                }

            }

        }
       return false;
    }

    private static boolean checkStartDate(Field field, BusTicket busTicket) {
        if (field.getName().equals("startDate")) {
            field.setAccessible(true);
            LocalDate ticketTime = busTicket.getStartDate();
            try {
                if (ticketTime.isAfter(LocalDate.now())) {
                    System.out.println("Date cannot be in the future");
                    falseTicketDate++;
                    System.out.println("False ticket date " + falseTicketDate);
                    return false;
                }
            } catch (NullPointerException e) {
                System.out.println("Date null");

            }
        }
        return false;
    }

    private static boolean checkTicketPrice(Field field, BusTicket busTicket) {
        if (field.getName().equals("ticketPrice")) {
            field.setAccessible(true);
            int price = busTicket.getTicketPrice();
            if (price % 2 != 0) {
                System.out.println("Price must be even");
                falseTicketPrice++;
                System.out.println("False ticket price " + falseTicketPrice);
                return false;
            }
            else if (price == 0) {
                System.out.println("Price cannot be 0");
                falseTicketPrice++;
                System.out.println("False ticket price " + falseTicketPrice);
                return false;
            }
            else if(Integer.valueOf(busTicket.getTicketPrice()) == null) {
                System.out.println("Price cannot be null");
                falseTicketPrice++;
                System.out.println("False ticket price " + falseTicketPrice);
                return false;
            }
        }
        return false;
    }
}
package homework4;

import java.lang.reflect.Field;

import java.time.LocalDateTime;

public class TicketValidator {
private static int trueTickets = 0;
private static int falseTickets = 0;
    public boolean checkTicket(BusTicket busTicket) {
        Field[] fields = busTicket.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("ticketType")) {
                field.setAccessible(true);
               String ticketType = busTicket.getTicketType();
                if(!(ticketType.equals("DAY") || ticketType.equals("WEEK")|| ticketType.equals("MONTH")||
                   ticketType.equals("YEAR"))) {
                    System.out.println("Unacceptible ticket type");
                    falseTickets++;
                    return false;
                }
                if (ticketType.equals("MONTH")) {
                    LocalDateTime startDate = busTicket.getStartDate();
                    if (startDate != null) {
                        System.out.println("This ticket shouldn't have start date");
                        falseTickets++;
                        return false;
                    }
                }
            } else if (field.getName().equals("startDate")) {
                field.setAccessible(true);
                LocalDateTime ticketTime = busTicket.getStartDate();
                if (ticketTime.isAfter(LocalDateTime.now())) {
                    System.out.println("DAte wrong");
                    falseTickets++;
                    return false;
                }

            } else if (field.getName().equals("ticketPrice")) {
                field.setAccessible(true);
                int price = busTicket.getTicketPrice();
                if (price % 2 != 0) {
                    System.out.println("Price wrong");
                    falseTickets++;
                    return false;
                }
            }
        }
        System.out.println("Ticket is ok");
        trueTickets++;
        return true;
    }
}
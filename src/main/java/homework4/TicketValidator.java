package homework4;

import java.lang.reflect.Field;

import java.time.LocalDateTime;

public class TicketValidator {

    public boolean checkTicket(BusTicket busTicket) {
        Field[] fields = busTicket.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("ticketType")) {
                field.setAccessible(true);
                TicketType ticketType = busTicket.getTicketType();
                if (ticketType.equals(TicketType.MONTH)) {

                    LocalDateTime startDate = busTicket.getStartDate();
                    if (startDate != null) {
                        System.out.println("This ticket should/t have start date");
                        return false;
                    }
                }
            } else if (field.getName().equals("startDate")) {
                field.setAccessible(true);
                LocalDateTime ticketTime = busTicket.getStartDate();
                if (ticketTime.isAfter(LocalDateTime.now())) {
                    System.out.println("DAte wrong");
                    return false;
                }

            } else if (field.getName().equals("pprice")) {
                field.setAccessible(true);
                int price = busTicket.getPprice();
                if (price % 2 != 0) {
                    System.out.println("Price wrong");
                    return false;
                }
            }
        }
        System.out.println("Ticket is ok");
        return true;
    }
}
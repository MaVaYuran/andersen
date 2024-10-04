package by.mariayuran.homework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TicketValidator {
    private static int falseTicketType = 0;
    private static int falseTicketDate = 0;
    private static int falseTicketPrice = 0;

    public List<Integer> checkTicket(BusTicket ticket) {
        List<Integer> violations = new ArrayList<>();
        if (!checkTicketType(ticket))
            violations.add(falseTicketType);
        if (!checkStartDate(ticket))
            violations.add(falseTicketDate);
        if (!checkTicketPrice(ticket))
            violations.add(falseTicketPrice);
        return violations;
    }

    private boolean checkTicketType(BusTicket busTicket) {
        if (busTicket.getTicketType() == null) {
            return false;
        }
        if (!(busTicket.getTicketType().equals(TicketType.DAY) || busTicket.getTicketType().equals(TicketType.WEEK) ||
              busTicket.getTicketType().equals(TicketType.MONTH) || busTicket.getTicketType().equals(TicketType.YEAR))) {
            falseTicketType++;
            return false;
        }

        return true;
    }

    private static boolean checkStartDate(BusTicket busTicket) {
        try {
            if (busTicket.getStartDate().isAfter(LocalDate.now())) {
                falseTicketDate++;
                return false;
            }
        } catch (NullPointerException e) {
            System.out.println("");
        }
        if ((TicketType.MONTH).equals(busTicket.getTicketType())) {
            if (busTicket.getStartDate() != null) {
                falseTicketDate++;
                return false;
            }
        }
        return true;
    }


    private static boolean checkTicketPrice(BusTicket busTicket) {

        if (busTicket.getTicketPrice() == null || busTicket.getTicketPrice() <= 0 || busTicket.getTicketPrice() % 2 != 0) {
            falseTicketPrice++;
            return false;
        }
        return true;
    }


    public void printViolation() {
        if (falseTicketType > falseTicketDate && falseTicketType > falseTicketPrice) {
            System.out.printf("Most popular violation: wrong type  - " + falseTicketType);
        } else if (falseTicketDate > falseTicketType && falseTicketDate > falseTicketPrice) {
            System.out.printf("Most popular violation: wrong date - " + falseTicketDate);
        } else
            System.out.printf("Most popular violation: wrong price - " + falseTicketPrice);
    }


}


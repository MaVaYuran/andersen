package homework4;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import java.io.File;
import java.io.IOException;
import java.util.List;


public class JsonParser {
    public static void main(String[] args) {
        List<BusTicket> tickets;
        String filePath = "tickets.json";
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            tickets = mapper.readValue(new File(filePath),
                    new TypeReference<List<BusTicket>>() {
                    });
            System.out.println(tickets);
            TicketValidator validator = new TicketValidator();
            int index = 1;
            for (BusTicket ticket : tickets) {
                System.out.println("Ticket #" + index +":");
                index++;

                validator.checkTicket(ticket);

            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            validator.printInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

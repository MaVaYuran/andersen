package homework4;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import java.io.File;
import java.io.IOException;
import java.util.List;


public class JsonParser {
    public static void main(String[] args) {
        String filePath = "tickets.json";
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<BusTicket> tickets = mapper.readValue(new File(filePath),
                    new TypeReference<List<BusTicket>>() {
                    });

            for (BusTicket ticket : tickets) {
                System.out.println(ticket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package by.mariayuran.homework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public List<BusTicket> parseJSON() {
        List<BusTicket> tickets = new ArrayList<>();
        String filePath = "src/main/resources/tickets.json";
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            tickets = mapper.readValue(new File(filePath),
                    new TypeReference<List<BusTicket>>() {
                    });
            System.out.println(tickets);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tickets;
    }
}

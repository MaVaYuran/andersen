package by.mariayuran.hibernate.service;

import by.mariayuran.hibernate.entity.JsonTicket;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class JSONTicketLoader {
    @Autowired
    private ResourceLoader resourceLoader;

    public List<JsonTicket> loadTicketsFromJSON() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:tickets.json");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(resource.getInputStream(), new TypeReference<List<JsonTicket>>() {
        });
    }
}

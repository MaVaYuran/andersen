package by.mariayuran.hibernate.entity;


import lombok.*;
import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class JsonTicket {

    private String ticketClass;
    private String ticketType;
    private String startDate;
    private BigDecimal ticketPrice;

}

package homework;

import com.fasterxml.jackson.annotation.JsonFormat;

public enum TicketClass  {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    CLA,
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    STD
}

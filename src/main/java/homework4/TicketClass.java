package homework4;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

public enum TicketClass  {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    CLA,
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    STD
}

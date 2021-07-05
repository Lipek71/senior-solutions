package cinema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private Long id;
    private String title;
    private LocalDateTime date;
    private int maxReservation;
    private int freeSpaces;

    public void reservation(int reservation){
        if (reservation > getFreeSpaces()) {
            throw new IllegalStateException("Not enough free spaces");
        }
        setFreeSpaces(getFreeSpaces()-reservation);
    }

}

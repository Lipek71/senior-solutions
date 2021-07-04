package musicstore;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Instrument {
    private Long id;
    private String brand;
    private InstrumentType Type;
    private int price;
    private LocalDate postDate;
}

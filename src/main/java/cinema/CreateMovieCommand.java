package cinema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovieCommand {

    @NotBlank(message = "Name can't be empty")
    private String title;
    private LocalDateTime date;
    @Min(20)
    private int maxReservation;

}

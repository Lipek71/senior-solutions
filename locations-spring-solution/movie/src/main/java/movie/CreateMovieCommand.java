package movie;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMovieCommand {

    @Schema(description = "Name of the movie.", example = "Csillagok háborúja")
    private String title;
}

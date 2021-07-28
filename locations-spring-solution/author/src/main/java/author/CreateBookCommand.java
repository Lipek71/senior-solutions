package author;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookCommand {

    @Schema(description = "ISBN number", example = "1238941231")
    private String numberISBN;

    @Schema(description = "Title of the book.", example = "Grant kapitány gyermekei")
    private String title;
}

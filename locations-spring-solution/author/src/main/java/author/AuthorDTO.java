package author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {

    private Long id;

    private String name;

    private List<BookDTO> bookList;
}

package author;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/authors")
@Tag(name = "Operations on authors.")
public class AuthorController {

    final private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    @Operation(summary = "List authors and her/his books.")
    public List<AuthorDTO> getAuthors(){
        return authorService.getAuthors();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creates an author.")
    @ApiResponse(responseCode = "201", description = "Author has been created.")
    public AuthorDTO createAuthor(@RequestBody CreateAuthorCommand command){
        return authorService.createAuthor(command);
    }

    @PostMapping("/{id}")
    @Operation(summary = "Add a book.")
    public AuthorDTO addBookToAuthor(@PathVariable("id") long id, @RequestBody CreateBookCommand command){
        return authorService.addBookToAuthor(id, command);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a book.")
    public void deleteAuthor(@PathVariable("id") long id){
        authorService.deleteAuthor(id);
    }
}

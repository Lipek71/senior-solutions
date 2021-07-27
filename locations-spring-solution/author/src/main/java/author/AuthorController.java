package author;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/authors")
public class AuthorController {

    final private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorDTO> getAuthors(){
        return authorService.getAuthors();
    }

    @PostMapping
    public AuthorDTO createAuthor(@RequestBody CreateAuthorCommand command){
        return authorService.createAuthor(command);
    }

    @PostMapping("/{id}")
    public AuthorDTO addBookToAuthor(@PathVariable("id") long id, @RequestBody CreateBookCommand command){
        return authorService.addBookToAuthor(id, command);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable("id") long id){
        authorService.deleteAuthor(id);
    }
}

package author;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorService {

    private AuthorRepository authorRepository;

    private ModelMapper modelMapper;

    public List<AuthorDTO> getAuthors() {
        return authorRepository.findAll().stream()
                .map(a->modelMapper.map(a, AuthorDTO.class))
                .collect(Collectors.toList());
    }

    public AuthorDTO createAuthor(CreateAuthorCommand command) {
        Author author = new Author(command.getName());

        authorRepository.save(author);

        return modelMapper.map(author, AuthorDTO.class);
    }

    @Transactional
    public AuthorDTO addBookToAuthor(long id, CreateBookCommand command) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cannot find"));
        Book book = new Book(command.getNumberISBN(), command.getTitle());

        author.addBook(book);

        return modelMapper.map(author, AuthorDTO.class);
    }

    public void deleteAuthor(long id) {
        authorRepository.deleteById(id);
    }
}

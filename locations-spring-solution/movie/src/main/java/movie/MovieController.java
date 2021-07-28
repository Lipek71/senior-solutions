package movie;

import author.AuthorDTO;
import author.CreateAuthorCommand;
import author.CreateBookCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
@Tag(name = "Operations on movies.")
public class MovieController {

    final private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @Operation(summary = "List movies and its ratings.")
    public List<MovieDTO> getMovies(){
        return movieService.getMovies();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creates a movie.")
    @ApiResponse(responseCode = "201", description = "Movie has been created.")
    public MovieDTO createMovie(@RequestBody CreateMovieCommand command){
        return movieService.createMovie(command);
    }

    @PostMapping("/{id}/rating")
    @Operation(summary = "Add a rating.")
    public MovieDTO addRatingToMovie(@PathVariable("id") long id, @RequestBody CreateRatingCommand command){
        return movieService.addRatingToMovie(id, command);
    }
}

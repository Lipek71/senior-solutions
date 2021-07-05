package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cinema")
public class MovieController {

    final private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDTO> listMovies(@RequestParam Optional<String> title) {
        return movieService.listMovies(title);
    }

    @GetMapping("/{id}")
    public MovieDTO listMovieById(@PathVariable("id") long id) {
        return movieService.listMovieById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDTO createMovie(@Valid @RequestBody CreateMovieCommand command) {
        return movieService.createMovie(command);
    }

    @PostMapping("/{id}/reserve")
    public MovieDTO updateMovieFreePlace(@PathVariable("id") long id, @RequestBody CreateReservationCommand command) {
        return movieService.createReservation(id, command);
    }

    @PutMapping("/{id}")
    public MovieDTO updateMovieDate(@PathVariable("id") long id, @RequestBody UpdateDateCommand command) {
        return movieService.updateMovie(id, command);
    }

    @DeleteMapping
    public void deleteMovieAll() {
        movieService.deleteMovieAll();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Problem> handleNotFound(IllegalArgumentException iae) {
        Problem problem =
                Problem.builder()
                        .withType(URI.create("cinema/not-found"))
                        .withTitle("Not found")
                        .withStatus(Status.NOT_FOUND)
                        .withDetail(iae.getMessage())
                        .build();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(problem);
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Problem> badRequest(IllegalStateException ise) {
        Problem problem =
                Problem.builder()
                        .withType(URI.create("cinema/bad-reservation"))
                        .withTitle("Bad request")
                        .withStatus(Status.BAD_REQUEST)
                        .withDetail(ise.getMessage())
                        .build();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(problem);
    }



}

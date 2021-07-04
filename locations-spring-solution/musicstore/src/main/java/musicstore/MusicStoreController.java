package musicstore;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/instruments")
public class MusicStoreController {

    final private MusicStoreService musicstoreService;

    //@Autowired
    public MusicStoreController(MusicStoreService musicStoreService) {
        this.musicstoreService = musicStoreService;
    }

    @GetMapping
    public List<InstrumentDTO> listInstruments(@RequestParam Optional<String> brand, @RequestParam Optional<Integer> price) {
        return musicstoreService.listInstruments(brand, price);
    }

    @GetMapping("/{id}")
    public InstrumentDTO listInstrumentById(@PathVariable("id") long id) {
        return musicstoreService.listInstrumentById(id);
    }

    //@GetMapping("/{id}")
    //public ResponseEntity listInstrumentById(@PathVariable("id") long id) {
    //    try {
    //        return ResponseEntity.ok(musicstoreService.listInstrumentById(id));
    //    } catch (IllegalArgumentException iea) {
    //        return ResponseEntity.notFound().build();
    //    }
    //}
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InstrumentDTO createInstrument(@Valid @RequestBody CreateInstrumentCommand command) {
        return musicstoreService.createInstruments(command);
    }

    @PutMapping("/{id}")
    public InstrumentDTO updatePrice(@PathVariable("id") long id, @Valid @RequestBody UpdatePriceCommand command) {
        return musicstoreService.updatePrice(id, command);
    }

    @DeleteMapping("/{id}")
    public void deleteInstrument(@PathVariable("id") long id) {
        musicstoreService.deleteInstrument(id);
    }

    @DeleteMapping
    public void deleteInstrumentAll() {
        musicstoreService.deleteInstrumentAll();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Problem> handleNotFound(IllegalArgumentException iae) {
        Problem problem =
                Problem.builder()
                        .withType(URI.create("instruments/not-found"))
                        .withTitle("Not found")
                        .withStatus(Status.NOT_FOUND)
                        .withDetail(iae.getMessage())
                        .build();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(problem);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Problem> handleValidException(MethodArgumentNotValidException e) {
        List<Violation> violations =
                e.getBindingResult().getFieldErrors().stream()
                        .map(fe -> new Violation(fe.getField(), fe.getDefaultMessage()))
                        .collect(Collectors.toList());

        Problem problem =
                Problem.builder()
                        .withType(URI.create("instrument-data/not-valid"))
                        .withTitle("Validation error")
                        .withStatus(Status.BAD_REQUEST)
                        .withDetail(e.getMessage())
                        .with("violations", violations)
                        .build();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(problem);
    }
}

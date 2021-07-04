package locations;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationsController {

    private final LocationsService locationService;

    public LocationsController(LocationsService locationService) {
        this.locationService = locationService;
    }

//    @GetMapping()
//    public String getLocations() {
//
//        List<Location> favouritePlaces = locationService.getFavouritePlaces(();
//
//        String output = "";
//        for (Location location : favouritePlaces) {
//            output += location.toString() + "<br>";
//        }
//        output += LocalDateTime.now();
//
//        return output;
//    }

    @GetMapping()
    public List<LocationDTO> getLocations(@RequestParam Optional<String> place) {
        return locationService.getFavouritePlaces(place);
    }

    @GetMapping("/{id}")
    public LocationDTO getLocationById(@PathVariable("id") long id){
        return locationService.getFavouritePlaceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LocationDTO createInstrument( @RequestBody CreateLocationCommand command) {
        return locationService.createFavouritePlace(command);
    }

    @PutMapping("/{id}")
    public LocationDTO updatePrice(@PathVariable("id") long id, @RequestBody UpdateLocationCommand command) {
        return locationService.updatePrice(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFavouritePlace(@PathVariable("id") long id) {
        locationService.deleteFavouritePlace(id);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Problem> LocationNotFoundException(IllegalArgumentException iae) {
        Problem problem =
                Problem.builder()
                        .withType(URI.create("location/not-found"))
                        .withTitle("Not found")
                        .withStatus(Status.NOT_FOUND)
                        .withDetail(iae.getMessage())
                        .build();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(problem);
    }


}

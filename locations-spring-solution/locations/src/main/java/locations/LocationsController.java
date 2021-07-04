package locations;

import org.springframework.web.bind.annotation.*;

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

}

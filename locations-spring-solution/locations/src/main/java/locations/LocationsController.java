package locations;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class LocationsController {

    private final LocationsService locationService;

    public LocationsController(LocationsService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/locations")
    public String getLocations() {

        List<Location> favouritePlaces = locationService.locations();

        String output = "";
        for (Location location : favouritePlaces) {
            output += location.toString() + "<br>";
        }
        output += LocalDateTime.now();

        return output;
    }

}

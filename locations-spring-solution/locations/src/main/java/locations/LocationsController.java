package locations;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class LocationsController {

    private final LocationService locationService;

    public LocationsController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/locations")
    public String getLocations() {

        List<Location> favouritePlace = locationService.locations();

        String output = "";
        for (Location location : favouritePlace) {
            output += location.toString();
        }
        output += LocalDateTime.now();

        return output;
    }

}

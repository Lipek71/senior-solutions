package locations;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

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
    public List<LocationDTO> getLocations() {
        return locationService.getFavouritePlaces();
    }

}

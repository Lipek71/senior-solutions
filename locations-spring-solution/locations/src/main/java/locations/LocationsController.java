package locations;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LocationsController {

    private final List<Location> favouritePlace = new ArrayList<>(List.of(
            new Location(1L, "Velence", 47.24, 18.64),
            new Location(2L, "Herceghalom", 47.49, 18.74)));

    @GetMapping("/")
    public String  getLocations(){
        String output = "";
        for (Location location : favouritePlace){
            output += location.toString();
        }
        output += LocalDateTime.now();

        return output;
    }

}

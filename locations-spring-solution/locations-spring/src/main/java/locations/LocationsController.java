package locations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LocationsController {

    private final List<Location> favouritePlace = new ArrayList<>(List.of(
            new Location(1L, "Velence", 47.24, 18.64),
            new Location(2L, "Herceghalom", 47.49, 18.74)));

    @GetMapping("/")
    @ResponseBody
    public String  getLocations(){
        String output = "";
        for (Location location : favouritePlace){
            output += location.toString() + "\n";
        }
        output += LocalDateTime.now();

        return output;
    }

}

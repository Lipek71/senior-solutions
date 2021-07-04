package locations;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    private final List<Location> favouritePlace = new ArrayList<>(List.of(
            new Location(1L, "Velence", 47.24, 18.64),
            new Location(2L, "Herceghalom", 47.49, 18.74)));

    public List<Location> locations() {
        return favouritePlace;
    }
}

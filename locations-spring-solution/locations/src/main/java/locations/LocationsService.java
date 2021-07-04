package locations;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationsService {

    private final List<Location> favouritePlaces = new ArrayList<>(List.of(
            new Location(1L, "Velence", 47.24, 18.64),
            new Location(2L, "Herceghalom", 47.49, 18.74)));

    public List<Location> getFavouritePlaces() {
        return favouritePlaces;
    }

    public List<Location> locations() {
        return favouritePlaces;
    }
}

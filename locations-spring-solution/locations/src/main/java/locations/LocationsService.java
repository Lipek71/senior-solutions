package locations;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class LocationsService {

    private ModelMapper modelMapper;
    private AtomicLong idGenerator = new AtomicLong();
    public LocationsService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    private final List<Location> favouritePlaces = Collections.synchronizedList(new ArrayList<>(List.of(
            new Location(idGenerator.incrementAndGet(), "Velence", 47.24, 18.64),
            new Location(idGenerator.incrementAndGet(), "Herceghalom", 47.49, 18.74))));

    public List<LocationDTO> getFavouritePlaces(Optional<String> place) {
        Type targetListType = new TypeToken<List<LocationDTO>>(){}.getType();
        List<Location> filtered = favouritePlaces.stream()
                .filter(f -> place.isEmpty() || f.getName().equalsIgnoreCase(place.get()))
                .collect(Collectors.toList());
        return modelMapper.map(filtered, targetListType);
    }

    public LocationDTO getFavouritePlaceById(long id) {
        return modelMapper.map(favouritePlaces.stream()
                .filter(f -> f.getId() == id).findAny()
                .orElseThrow(() -> new IllegalArgumentException("Place not found " + id)),
                LocationDTO.class);

    }
}

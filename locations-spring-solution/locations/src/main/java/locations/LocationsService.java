package locations;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.description.method.MethodDescription;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LocationsService {

    private ModelMapper modelMapper;

    public LocationsService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    private final List<Location> favouritePlaces = Collections.synchronizedList(new ArrayList<>(List.of(
            new Location(1L, "Velence", 47.24, 18.64),
            new Location(2L, "Herceghalom", 47.49, 18.74))));

    public List<LocationDTO> getFavouritePlaces() {
        Type targetListType = new TypeToken<List<LocationDTO>>(){}.getType();
        return modelMapper.map(favouritePlaces, targetListType);
    }
}

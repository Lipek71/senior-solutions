package locations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LocationsControllerTest {

    @Mock
    LocationsService locationsService;
//    private final List<Location> favouritePlaces = new ArrayList<>(List.of(
//            new Location(1L, "Velence", 47.24, 18.64),
//            new Location(2L, "Herceghalom", 47.49, 18.74)));
    private final List<LocationDTO> favouritePlaces = new ArrayList<>(List.of(
            new LocationDTO(1L, "Velence", 47.24, 18.64),
            new LocationDTO(2L, "Herceghalom", 47.49, 18.74)));

    @InjectMocks
    LocationsController locationsController;

//    @Test
//    void getLocations() {
//
//        when(locationsService.getFavouritePlaces()).thenReturn(favouritePlaces);
//
//        List<LocationDTO> result = locationsController.getLocations();
//
//        assertThat(result.toString()).startsWith("[LocationDTO(id=1, name=Velence,");
//
//    }
}
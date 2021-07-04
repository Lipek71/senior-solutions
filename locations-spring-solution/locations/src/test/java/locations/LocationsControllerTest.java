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
    private final List<Location> favouritePlaces = new ArrayList<>(List.of(
            new Location(1L, "Velence", 47.24, 18.64),
            new Location(2L, "Herceghalom", 47.49, 18.74)));


    @InjectMocks
    LocationsController locationsController;

    @Test
    void getLocations() {

        when(locationsService.locations()).thenReturn(favouritePlaces);

        System.out.println(locationsController.getLocations());

        String result = locationsController.getLocations();

       //assertThat(favouritePlaces.startsWith("Location{id=1, name='Velence'"));
        assertThat(result).startsWith("Location{id=1, name='Velence',");

    }
}
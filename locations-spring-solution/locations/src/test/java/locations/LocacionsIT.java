package locations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class LocacionsIT {

    @Autowired
    LocationsController locationsController;

//    @Test
//    void getLocations() {
//        String favouritePlaces = locationsController.getLocations().toString();
//
//        assertThat(favouritePlaces).startsWith("[LocationDTO(id=1, name=Velence");
//    }
}

package appointment;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class NavService {
    private List<NavCaseType> navCaseTypes = new ArrayList<>(List.of(
            new NavCaseType(001, "Adóbevallás"),
            new NavCaseType(002, "Önellenőrzés"),
            new NavCaseType(003, "Vállalkozói adó")));

    private ModelMapper modelMapper;

    public NavService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<NavCaseTypeDTO> listNavCaseTypes() {
        Type targetListType = new TypeToken<List<NavCaseTypeDTO>>(){}.getType();

        return modelMapper.map(navCaseTypes, targetListType);
    }
}

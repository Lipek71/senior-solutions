package appointment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class NavController {

    final private NavService navService;

    //@Autowired
    public NavController(NavService navService) {
        this.navService = navService;
    }

    @GetMapping("/api/types")
    public List<NavCaseTypeDTO> listNavCaseTypes() {
        return navService.listNavCaseTypes();
    }


}

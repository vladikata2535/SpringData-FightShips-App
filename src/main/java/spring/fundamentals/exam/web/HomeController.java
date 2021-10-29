package spring.fundamentals.exam.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.fundamentals.exam.security.CurrentUser;
import spring.fundamentals.exam.service.ShipService;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ShipService shipService;
    private final ModelMapper modelMapper;

    public HomeController(CurrentUser currentUser, ShipService shipService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String index(Model model){
        if(currentUser.getId() == null){
            return "index";
        }
        model.addAttribute("ships", shipService.getAllShipsOrderedByIdAndStatus());
        model.addAttribute("attackerShips", shipService.getAllLoggedInUserShips());
        model.addAttribute("defendersShips", shipService.findAllDefendersShips());

        return "home";
    }
}

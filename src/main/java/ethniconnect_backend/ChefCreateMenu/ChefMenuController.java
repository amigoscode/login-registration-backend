package ethniconnect_backend.ChefCreateMenu;

import ethniconnect_backend.ChefDetails.Chef;
import ethniconnect_backend.ChefDetails.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChefMenuController {

    @Autowired
    private ChefMenuService chefMenuService;
    @Autowired
    private ChefMenuRepository chefMenuRepository;

    @PostMapping("/chefmenu")
    public ResponseEntity<String> addChefMenu(@RequestBody ChefMenuRequest chefMenuRequest) throws Exception
    {

        //chefMenuService.saveChefMenu(ch);
        chefMenuService.saveChefMenu(chefMenuRequest);

        return new ResponseEntity<>("menu item saved successfully", HttpStatus.OK);
    }
   /* @PostMapping("/chefs")
    public List<Chef> addChefs(@RequestBody List<Chef> chefs)
    {
        return chefProfileService.saveChefs(chefs);
    }*/

    @GetMapping({"/chefmenuyId/{id}"})
    public ChefMenu findChefMenuById(@PathVariable int id)
    {
        return chefMenuService.getChefMenuById(id);
    }

    @PutMapping("/updatechefmenu")
    public ChefMenu updateChefMenu(@RequestBody ChefMenu chefMenu)
    {
        return chefMenuService.updateChefMenu(chefMenu);
    }
}



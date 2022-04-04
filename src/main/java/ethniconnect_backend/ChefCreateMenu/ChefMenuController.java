package ethniconnect_backend.ChefCreateMenu;

import ethniconnect_backend.ChefDetails.Chef;
import ethniconnect_backend.ChefDetails.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin()
@RestController
public class ChefMenuController {

    @Autowired
    private ChefMenuService chefMenuService;
    @Autowired
    private ChefMenuRepository chefMenuRepository;

    @PostMapping("/chefmenu")

    public String addChefMenu(@RequestParam("file") MultipartFile file,
                          @RequestParam("login_id") long login_id,
                          @RequestParam("menucategories") MenuCategories menuCategories,
                          @RequestParam("cuisine_id") int cuisine_id,
                              @RequestParam("item_name") String item_name,

                          @RequestParam("menu_item_price") double menu_item_price,
                          @RequestParam("item_ingredients") String item_ingredients,
                          @RequestParam("item_intresting_facts") String item_intresting_facts,
                          @RequestParam("week") Week week) throws Exception {
        chefMenuService.saveChefMenu(file, login_id, menuCategories,cuisine_id,
                item_name,menu_item_price,item_ingredients,item_intresting_facts,week);
        return "chef details added";
    }

    @GetMapping({"/chefmenuById/{id}"})
    public ChefMenuGETResponse findChefMenuById(@PathVariable int id)
    {
        return chefMenuService.getChefMenuById(id);
    }

    @PutMapping("/updatechefmenu")
    public ChefMenu updateChefMenu(@RequestBody ChefMenu chefMenu)
    {
        return chefMenuService.updateChefMenu(chefMenu);
    }
}



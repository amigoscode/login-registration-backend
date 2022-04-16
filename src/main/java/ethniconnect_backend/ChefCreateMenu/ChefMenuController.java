package ethniconnect_backend.ChefCreateMenu;

import ethniconnect_backend.ChefDetails.Chef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
public class ChefMenuController {

    @Autowired
    private ChefMenuService chefMenuService;
    @Autowired
    private ChefMenuRepository chefMenuRepository;

    @PostMapping("/chefmenu")

    public String addChefMenu(@RequestBody ChefMenuRequest chefMenuRequest) throws Exception {

        chefMenuService.saveChefMenuJson(chefMenuRequest);

        /*chefMenuService.saveChefMenu(file, login_id, menuCategories,cuisine_id,
                item_name,menu_item_price,item_ingredients,item_intresting_facts,week);*/
        return "Menu details added";
    }

   /* public String addChefMenu(@RequestParam("file") MultipartFile file,
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
*/
    @GetMapping({"/ChefmenuByChefloginid/{id}"})
    public ChefMenuGETResponse findChefMenuById(@PathVariable int id)
    {
        Long loginidlong = new Long(id);
        return chefMenuService.getChefMenuByLoginId(loginidlong.longValue());
    }

   @GetMapping({"/chefByCuisineId/{id}/{zipCode}"})
    public List<Chef> findChefByCuisineId(@PathVariable int id, @PathVariable int zipCode)
    {
        return chefMenuService.getChefByCuisineId(id,zipCode);
    }

    @PutMapping("/updatechefmenu")
    public ChefMenu updateChefMenu(@RequestBody ChefMenu chefMenu)
    {
        return chefMenuService.updateChefMenu(chefMenu);
    }
}
 /*@GetMapping({"/chefByCuisineId/{cuisineId}"})
 public List<Chef> getChefByCuisineId(@PathVariable String cuisineId)
 {
     return chefProfileService.getChefByCuisineId(cuisineId);
 }

 @GetMapping({"/getCuisinesByZipCode/{zipCode}"})
 public List<CuisineCategory> getCuisinesByZipCode(@PathVariable String zipCode)
 {
     return chefProfileService.getCuisinesByZipCode(zipCode);
 }*/



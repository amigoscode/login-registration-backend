package ethniconnect_backend.ChefDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChefController {
    @Autowired
    private ChefService chefProfileService;

    @PostMapping("/chef")
    public Chef addChef(@RequestBody Chef chef) throws Exception
     {

         return chefProfileService.saveChef(chef);
     }
   /* @PostMapping("/chefs")
    public List<Chef> addChefs(@RequestBody List<Chef> chefs)
    {
        return chefProfileService.saveChefs(chefs);
    }*/

   @GetMapping({"/chefById/{id}"})
   public Chef findChefById(@PathVariable int id)
   {
       return chefProfileService.getChefById(id);
   }

    @PutMapping("/updatechef")
    public Chef updateChef(@RequestBody Chef chef)
    {
        return chefProfileService.updateChef(chef);
    }
}

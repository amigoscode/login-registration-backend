package ethniconnect_backend.Cuisines;


import ethniconnect_backend.ChefDetails.Chef;
import ethniconnect_backend.ChefDetails.ChefRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin()
@RestController
public class CuisineCategoriesController {

    @Autowired
    private CuisinesCategoriesService cuisinesCategoriesService;

    @PostMapping("/CuisineCategory")
    public CuisineCategory addcuisinecategory(@RequestBody CuisineCategory cuisineCategories)
    {

        return cuisinesCategoriesService.saveCuisineCatgeory(cuisineCategories);
    }

    @GetMapping({"/CuisnesCategoryRequests"})
    public List<CuisineCategory> findcontactrequests()

    {
        return cuisinesCategoriesService.getCusineCategoriesRequets();
    }

    @GetMapping({"/ContactCategoryById/{id}"})
    public CuisineCategory findcuisinecategoryrequestbyId(@PathVariable int id)
    {
        return cuisinesCategoriesService.getCuisineCategoryById(id);
    }

    @PutMapping("/updatecuisine")
    public CuisineCategory updateChef(@RequestBody CuisineCategory cuisineCategory) {
        return cuisinesCategoriesService.Updatecuisinecategory(cuisineCategory);
    }

}



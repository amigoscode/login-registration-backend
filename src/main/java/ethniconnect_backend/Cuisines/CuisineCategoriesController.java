package ethniconnect_backend.Cuisines;


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

}



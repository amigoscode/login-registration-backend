package ethniconnect_backend.Cuisines;

import ethniconnect_backend.ChefDetails.Chef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CuisinesCategoriesService {

    @Autowired
    public CuisineCategoriesRepository cuisineCategoriesRepository;
    public CuisineCategory saveCuisineCatgeory(CuisineCategory cuisineCategories)
    {
        return (CuisineCategory) cuisineCategoriesRepository.save(cuisineCategories);
    }

    public List<CuisineCategory> getCusineCategoriesRequets()
    {
        return cuisineCategoriesRepository.findAll();
    }
    public CuisineCategory getCuisineCategoryById(int id)
    {
        return (CuisineCategory) cuisineCategoriesRepository.findById(id).orElse(null);
    }
    public CuisineCategory Updatecuisinecategory(CuisineCategory cuisineCategory)
    {
        CuisineCategory existingCuisine = (CuisineCategory) cuisineCategoriesRepository.findById(cuisineCategory.getId()).orElse(null);
        existingCuisine.setCuisine_name(cuisineCategory.getCuisine_name() != null ? cuisineCategory.getCuisine_name() : existingCuisine.getCuisine_name());
        existingCuisine.setCuisine_image(cuisineCategory.getCuisine_image() != null ? cuisineCategory.getCuisine_image() : existingCuisine.getCuisine_image());

        return cuisineCategoriesRepository.save(existingCuisine);

    }

}


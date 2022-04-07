package ethniconnect_backend.Cuisines;

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

}


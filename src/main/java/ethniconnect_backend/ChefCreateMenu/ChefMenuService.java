package ethniconnect_backend.ChefCreateMenu;

import ethniconnect_backend.ChefDetails.Chef;
import ethniconnect_backend.Cuisines.CuisineCategoriesRepository;
import ethniconnect_backend.Cuisines.CuisineCategory;
import ethniconnect_backend.UserCredentials.UserCredentials;
import ethniconnect_backend.UserCredentials.UserCredentialsRepository;
import ethniconnect_backend.UserCredentials.UserCredentialsService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
@Service
public class ChefMenuService  {

    @Autowired
    private ChefMenuRepository chefMenuRepository;
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    CuisineCategoriesRepository cuisineCategoriesRepository;

    public ChefMenu saveChefMenu(ChefMenuRequest chefMenuRequest) throws Exception{
        Optional<UserCredentials> userData = userCredentialsRepository.findById(chefMenuRequest.getLogin_id());
        if(!userData.isPresent())
            throw new Exception("user Id doesn't exist");
        CuisineCategory cuisineCategory = cuisineCategoriesRepository.findById(chefMenuRequest.getCuisine_id()).get();
       // Long loginId = userData.get().getId();
        if(cuisineCategory == null)
            throw new Exception("cuisine category doesn't exist");
        ChefMenu chefMenu = new ChefMenu();
        chefMenu.setLogin_id(chefMenuRequest.getLogin_id());
        chefMenu.setMenucategories(chefMenuRequest.getMenucategories());
        chefMenu.setMenu_item_image(chefMenuRequest.getMenu_item_image());
        chefMenu.setMenu_item_price(chefMenuRequest.getMenu_item_price());
        chefMenu.setItem_name(chefMenuRequest.getItem_name());
        chefMenu.setItem_intresting_facts(chefMenuRequest.getItem_intresting_facts());
        chefMenu.setItem_ingredients(chefMenuRequest.getItem_ingredients());
        chefMenu.setCuisineCategory(cuisineCategory);
        chefMenu.setWeek(chefMenuRequest.getWeek());

        chefMenuRequest.setLogin_id(chefMenuRequest.getLogin_id());
        return chefMenuRepository.save(chefMenu);
    }
    public List<ChefMenu> saveChefMenus(List<ChefMenu> chefMenus){
        return chefMenuRepository.saveAll(chefMenus);
    }

    public List<ChefMenu> getChefMenus()
    {
        return chefMenuRepository.findAll();
    }
    public ChefMenu getChefMenuById(int chefMenu_id){
        return chefMenuRepository.findById(chefMenu_id).orElse(null);
    }

    public String deleteChefMenu(int chefMenu_id)
    {
        chefMenuRepository.deleteById(chefMenu_id);
        return "chef Menu ietem removed !!" + chefMenu_id;
    }
    public ChefMenu updateChefMenu(ChefMenu chefMenu)
    {
        ChefMenu existingChefMenu=chefMenuRepository.findById(chefMenu.getId()).orElse(null);
        existingChefMenu.setMenucategories(chefMenu.getMenucategories());
        existingChefMenu.setMenu_item_image(chefMenu.getMenu_item_image());
        existingChefMenu.setItem_name(chefMenu.getItem_name());
        existingChefMenu.setMenu_item_price(chefMenu.getMenu_item_price());
        existingChefMenu.setItem_ingredients(chefMenu.getItem_ingredients());
        existingChefMenu.setItem_intresting_facts(chefMenu.getItem_intresting_facts());
        existingChefMenu.setWeek(chefMenu.getWeek());
        existingChefMenu.getCuisineCategory().setId(chefMenu.getCuisineCategory().getId());
        return chefMenuRepository.save(existingChefMenu);

    }


}

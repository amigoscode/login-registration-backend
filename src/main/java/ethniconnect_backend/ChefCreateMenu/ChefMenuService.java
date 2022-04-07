package ethniconnect_backend.ChefCreateMenu;

import ethniconnect_backend.Cuisines.CuisineCategoriesRepository;
import ethniconnect_backend.Cuisines.CuisineCategory;
import ethniconnect_backend.UserCredentials.UserCredentials;
import ethniconnect_backend.UserCredentials.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
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



    public void saveChefMenu(MultipartFile file,  Long login_id,MenuCategories menucategories,int cuisine_id,
                         String item_name,double menu_item_price,String item_ingredients,
                         String item_intresting_facts,Week week
                        ) throws Exception
    {
        ChefMenu chefMenu =new ChefMenu();
        Optional<UserCredentials> userData = userCredentialsRepository.findById(login_id);
        if(!userData.isPresent())
            throw new Exception("user Id doesn't exist");
        Optional<CuisineCategory> cuisineCategory = cuisineCategoriesRepository.findById(cuisine_id);
        // Long loginId = userData.get().getId();
        if(cuisineCategory == null)
            throw new Exception("cuisine category doesn't exist");

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            chefMenu.setMenu_item_image(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        chefMenu.setLogin_id(login_id);
        chefMenu.setMenucategories(menucategories);

        chefMenu.setMenu_item_price(menu_item_price);
        chefMenu.setItem_name(item_name);
        chefMenu.setItem_intresting_facts(item_intresting_facts);
        chefMenu.setItem_ingredients(item_ingredients);
        chefMenu.setCuisineCategory(cuisineCategory.get());
        chefMenu.setWeek(week);

        chefMenuRepository.save(chefMenu);
    }

    public List<ChefMenu> saveChefMenus(List<ChefMenu> chefMenus){
        return chefMenuRepository.saveAll(chefMenus);
    }

    public List<ChefMenu> getChefMenus()
    {
        return chefMenuRepository.findAll();
    }
    public ChefMenuGETResponse getChefMenuById(int id)
    {
        ChefMenu chefMenu  = chefMenuRepository.findById(id).get();

        ChefMenuGETResponse chefMenuGETResponse = ChefMenuGETResponse.builder()
                .cuisine_id(chefMenu.getCuisineCategory().getId())
                .login_id(chefMenu.getLogin_id())
                .menucategories(chefMenu.getMenucategories())
                .item_name(chefMenu.getItem_name())
                .menu_item_image(chefMenu.getMenu_item_image())
                .menu_item_price(chefMenu.getMenu_item_price())
                .item_ingredients(chefMenu.getItem_ingredients())
                .item_intresting_facts(chefMenu.getItem_intresting_facts())
                .week(chefMenu.getWeek())
                .build();
        return chefMenuGETResponse;


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
/*public List<Chef> getChefByCuisineId(String cuisine_id){

        return chefRepository.getChefsByPrefCuisine(Integer.getInteger(cuisine_id));
    }
    public List<CuisineCategory> getCuisinesByZipCode(String zipCode){
        CuisineCategory cuisineCategory= new CuisineCategory();
        List<Chef> chefs = chefRepository.getChefsByZip(zipCode);
        Set<Integer> cuisineId =  chefs.stream().map(Chef::getPrefCuisine).distinct().collect(Collectors.toSet());
        List<CuisineCategory> cuisineCategories = cuisineCategoriesRepository.findAllById(cuisineId);
        return cuisineCategories;
    }
*/

}

package ethniconnect_backend.ChefCreateMenu;

import ethniconnect_backend.ChefDetails.Chef;
import ethniconnect_backend.ChefDetails.ChefRepository;
import ethniconnect_backend.Cuisines.CuisineCategoriesRepository;
import ethniconnect_backend.Cuisines.CuisineCategory;
import ethniconnect_backend.UserCredentials.UserCredentials;
import ethniconnect_backend.UserCredentials.UserCredentialsRepository;
import ethniconnect_backend.Zip.ZipCode;
import ethniconnect_backend.Zip.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ChefMenuService  {

    @Autowired
    private ChefMenuRepository chefMenuRepository;
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    CuisineCategoriesRepository cuisineCategoriesRepository;
    @Autowired
    private ChefRepository chefRepository;
    @Autowired
    private RestTemplate restTemplate;
    public void saveChefMenuJson(ChefMenuRequest chefMenuRequest) throws Exception{


        ChefMenu chefMenu =null;

        Optional<UserCredentials> userData = userCredentialsRepository.findById(chefMenuRequest.getLogin_id());
        if(!userData.isPresent())
            throw new Exception("user Id doesn't exist");
        Optional<CuisineCategory> cuisineCategory = cuisineCategoriesRepository.findById(chefMenuRequest.getCuisine_id());
        if(cuisineCategory == null)
            throw new Exception("cuisine category doesn't exist");

        Optional<Chef> chef = chefRepository.findByLoginid(chefMenuRequest.getLogin_id());
        if(chef==null)
            throw new Exception("chef doesn't exist");

        for(ChefMenuItem chefMenuItem:chefMenuRequest.getMenu())
        {
            // Long loginId = userData.get().getId();
            if(cuisineCategory == null)
                throw new Exception("cuisine category doesn't exist");
            chefMenu =new ChefMenu();
            chefMenu.setCuisineCategory(cuisineCategory.get());
            chefMenu.setChef(chef.get());
            chefMenu.setItem_name(chefMenuRequest.getItem_name());
            chefMenu.setMenu_item_image(chefMenuItem.getMenu_item_image());
            chefMenu.setMenucategories(chefMenuItem.getMenucategory());
            chefMenu.setItem_ingredients(chefMenuItem.getItem_ingredients());
            chefMenu.setMenu_item_price(chefMenuItem.getMenu_item_price());
            chefMenu.setWeek(chefMenuRequest.getWeek());
            chefMenuRepository.save(chefMenu);
        }

    }

    /*public void saveChefMenu(MultipartFile file,  int login_id,MenuCategories menucategories,int cuisine_id,
                         String item_name,double menu_item_price,String item_ingredients,
                         String item_intresting_facts,Week week
                        ) throws Exception
    {
        ChefMenu chefMenu =new ChefMenu();
        Optional<UserCredentials> userData = userCredentialsRepository.findByLoginid(login_id);
        if(!userData.isPresent())
            throw new Exception("user Id doesn't exist");
        Optional<CuisineCategory> cuisineCategory = cuisineCategoriesRepository.findById(cuisine_id);
        // Long loginId = userData.get().getId();
        if(cuisineCategory == null)
            throw new Exception("Cuisine doesn't exist");
        Optional<Chef> chef = chefRepository.findByLoginid(login_id);
        if(chef==null)
            throw new Exception("chef doesn't exist");
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
        chefMenu.setMenucategories(menucategories);

        chefMenu.setMenu_item_price(menu_item_price);
        chefMenu.setItem_name(item_name);
        chefMenu.setItem_intresting_facts(item_intresting_facts);
        chefMenu.setItem_ingredients(item_ingredients);
        chefMenu.setCuisineCategory(cuisineCategory.get());
        chefMenu.setWeek(week);

        chefMenuRepository.save(chefMenu);
    }*/

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

        /*ChefMenuGETResponse chefMenuGETResponse = ChefMenuGETResponse.builder()
                .cuisine_id(chefMenu.getCuisineCategory().getId())
                .login_id(chefMenu.getLogin_id())
                .menucategories(chefMenu.getMenucategories())
                .item_name(chefMenu.getItem_name())
                .menu_item_image(chefMenu.getMenu_item_image())
                .menu_item_price(chefMenu.getMenu_item_price())
                .item_ingredients(chefMenu.getItem_ingredients())
                .item_intresting_facts(chefMenu.getItem_intresting_facts())
                .week(chefMenu.getWeek())
                .build();*/
        return new ChefMenuGETResponse();


    }
    public List<Chef> getChefByCuisineId(int cuisineId, int zipCode) {
        String url = "https://www.zipcodeapi.com/rest/Ze6ACQDfcjCFyzV7odLA4qyMLa6QraqkfHusGNor4GHrcy5w8XnT0pS0g9VOHkp1/radius.json/"+zipCode+"/6/mile";
        List<ChefMenu> chefMenu  = chefMenuRepository.findAllByCuisineCategory_Id(cuisineId);
        Set<Chef> chefSet = chefMenu.stream().map(ChefMenu::getChef).collect(Collectors.toSet());
        Root zipCodeApiResponse = restTemplate.getForObject(url, Root.class);
        List<String> zipCodes = zipCodeApiResponse.getZip_codes().stream().map(ZipCode::getZip_code).collect(Collectors.toList());
        List<Chef> chefList = new ArrayList<>();
        for(Chef chef:chefSet){
            if(zipCodes.contains(chef.getChef_zip())){
                chefList.add(chef);
            }
        }
     return chefList;
    }
    public ChefMenuGETResponse getChefMenuByLoginId(long login_id) {
        Chef chef = new Chef();
        chef.setLoginid(login_id);
        List<ChefMenu> chefMenuList = chefMenuRepository.findAllByChef(chef);
        List<ChefMenuResponse> chefMenuResponseList = new ArrayList<>();

       /* ChefMenuGETResponse chefMenuGETResponse = ChefMenuGETResponse.builder()
                .cuisine_id(chefMenu.getCuisineCategory().getId())
                .login_id(chefMenu.getLogin_id())
                .menucategories(chefMenu.getMenucategories())
                .item_name(chefMenu.getItem_name())
                .menu_item_image(chefMenu.getMenu_item_image())
                .menu_item_price(chefMenu.getMenu_item_price())
                .item_ingredients(chefMenu.getItem_ingredients())
                .item_intresting_facts(chefMenu.getItem_intresting_facts())
                .week(chefMenu.getWeek())
                .build();*/
        for(ChefMenu chefMenu:chefMenuList)
        {
            chefMenuResponseList.add
                    ( ChefMenuResponse
                            .builder()
                            .menuid(chefMenu.getId())
                            .menu_item_image(chefMenu.getMenu_item_image()!=null?chefMenu.getMenu_item_image():null)
                            .menucategory(chefMenu.getMenucategories().toString())
                            .cuisineCategory(chefMenu.getCuisineCategory().getCuisine_name())
                            .menu_item_price(chefMenu.getMenu_item_price())
                            .item_name(chefMenu.getItem_name())
                            .item_ingredients(chefMenu.getItem_ingredients())
                            .item_intresting_facts(chefMenu.getItem_intresting_facts())
                            .week(chefMenu.getWeek()!=null?chefMenu.getWeek().toString():null)
                            .build()
                    );
        }
        return ChefMenuGETResponse.builder().chefMenuList(chefMenuResponseList).build();
    }

//        public String deleteChefMenu(int chefMenu_id)
//    {
//        chefMenuRepository.deleteById(chefMenu_id);
//        return "chef Menu ietem removed !!" + chefMenu_id;
//    }
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


//    public List<Chef> getChefByCuisineId(String cuisine_id){
//
//        return chefRepository.getChefsByPrefCuisine(Integer.getInteger(cuisine_id));
//    }
    /*public List<CuisineCategory> getCuisineCategoriesByZipCode(String zipCode){
        CuisineCategory cuisineCategory= new CuisineCategory();
        List<Chef> chefs = chefRepository.getChefsByZip(zipCode);
        Set<Integer> categorieId =  chefs.stream().map((chef)->chefMenuRepository.findByLogin_id(chef.getLogin_id())).map((chefMenu)->chefMenu.getCuisineCategory()).map((cuisineCategory)->cuisineCategory.getCuisine_name()).distinct().collect(Collectors.toSet());
        List<CuisineCategory> cuisineCategories = cuisineCategoriesRepository.findAllById(cuisineId);
        return cuisineCategories;
    }
*/
}

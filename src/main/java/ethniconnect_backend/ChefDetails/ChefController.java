package ethniconnect_backend.ChefDetails;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;

@CrossOrigin()
@RestController
public class ChefController {
    @Autowired
    private ChefService chefProfileService;
    @Autowired
    private ChefRepository chefRepository;

    @PostMapping("/chef")
    public void addchef(@RequestParam("file") MultipartFile file,
                          @RequestParam("chef_fname") String fname,
                          @RequestParam("chef_lname") String lname,
                          @RequestParam("chef_emailid") String emailid,
                          @RequestParam("chef_phone") String chef_phone,
                          @RequestParam("chef_street") String chef_street,
                          @RequestParam("chef_city") String chef_city,
                          @RequestParam("chef_state") String chef_state,
                          @RequestParam("chef_zip") String chef_zip,
                          @RequestParam("chef_paymode") String chef_paymode,
                          @RequestParam("chef_description") String chef_description,
                          @RequestParam("chef_experience") int chef_experience,
                          @RequestParam("chef_fblink") String chef_fblink,
                          @RequestParam("chef_linkdin") String chef_linkdin) throws Exception {
        chefProfileService.saveChef(file, fname, lname, emailid, chef_phone, chef_street,
                chef_city, chef_state, chef_zip, chef_paymode, chef_description,
                chef_experience, chef_fblink, chef_linkdin);
        //return "chef details added";
    }

   /* @PostMapping("/chef")
    public Chef addChef(@RequestBody Chef chef) throws Exception
    {
        return chefProfileService.saveChef(chef);
    }*/


    @GetMapping({"/chefByLoginId/{id}"})
    public Chef findChefById(@PathVariable int id) {
        Long loginidlong = new Long(id);
        return chefProfileService.getChefByLoginId(id);
    }

    @PutMapping("/updatechef")
    public Chef updateChef(@RequestBody ChefRequest chefRequest) {
        return chefProfileService.updateChef(chefRequest);
    }

  /* @GetMapping({"/chefprofile"})
    public List<ChefprofileResponse> getChefProfileInfo()
    {
        return chefRepository.getChefProfileInfo();
    }*/

    /*@PostMapping(value = "/chef", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public String upload(@RequestPart("chef") String chef, @RequestPart("chef_image") MultipartFile chef_image) throws Exception {
       chefProfileService.getJson(chef,chef_image);
       return "added";*/






}

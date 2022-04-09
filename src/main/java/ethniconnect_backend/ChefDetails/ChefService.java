package ethniconnect_backend.ChefDetails;

import ethniconnect_backend.UserCredentials.UserCredentialsRepository;
import ethniconnect_backend.UserCredentials.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ChefService {
    @Autowired
    private ChefRepository chefRepository;
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    public void saveChef(MultipartFile file, String fname, String lname, String emailid,
                         String chef_phone, String chef_street, String chef_city,
                         String chef_state, String chef_zip, String chef_paymode,
                         String chef_description, int chef_experience, String chef_fblink,
                         String chef_linkdin) throws Exception {
        Chef chef = new Chef();
        Optional<UserCredentials> userData = userCredentialsRepository.findByEmail(emailid);
        if (!userData.isPresent())
            throw new Exception("user Id doesn't exist");


        Long loginId = userData.get().getLoginid();

        chef.setLoginid(loginId);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a a valid file");
        }
        try {
            chef.setChef_image(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        chef.setChef_fname(fname);

        chef.setChef_lname(lname);
        chef.setChef_emailid(emailid);
        chef.setChef_city(chef_city);
        chef.setChef_phone(chef_phone);
        chef.setChef_street(chef_street);
        chef.setChef_state(chef_state);
        chef.setChef_zip(chef_zip);
        chef.setChef_paymode(chef_paymode);
        chef.setChef_description(chef_description);
        chef.setChef_experience(chef_experience);
        chef.setChef_fblink(chef_fblink);
        chef.setChef_linkdin(chef_linkdin);
        chefRepository.save(chef);
    }

    /*public Chef saveChef(Chef chef) throws Exception{
        Optional<UserCredentials> userData = userCredentialsRepository.findByEmail(chef.getChef_emailid());
        if(!userData.isPresent())
            throw new Exception("user Id doesn't exist");
        Long loginId = userData.get().getId();

        chef.setLogin_id(loginId);

        return chefRepository.save(chef);
    }*/
    public List<Chef> saveChefs(List<Chef> chefs) {
        return chefRepository.saveAll(chefs);
    }
    public Chef getChefByLoginId(long loginid) {

         Optional<Chef> chef = chefRepository.findByLoginid(loginid);
         return chef.get();
    }
    public List<Chef> getChefs() {
        return chefRepository.findAll();
    }

    public Chef getChefById(int chef_id) {
        return chefRepository.findById(chef_id).orElse(null);
    }

    public String deleteChef(int chef_id) {
        chefRepository.deleteById(chef_id);
        return "chef removed !!" + chef_id;
    }




   /* public Chef updateChef(Chef chef) {
        Chef existingChef = (Chef) chefRepository.findByLoginid(chef.getLoginid()).orElse(null);
        existingChef.setChef_fname(chef.getChef_fname() != null ? chef.getChef_fname() : existingChef.getChef_fname());
        existingChef.setChef_lname(chef.getChef_lname() != null ? chef.getChef_lname() : existingChef.getChef_lname());
        existingChef.setChef_phone(chef.getChef_phone() != null ? chef.getChef_phone() : existingChef.getChef_phone());
        existingChef.setChef_city(chef.getChef_city() != null ? chef.getChef_city() : existingChef.getChef_city());
        existingChef.setChef_description(chef.getChef_description() != null ? chef.getChef_description() : existingChef.getChef_description());
        existingChef.setChef_fblink(chef.getChef_fblink() != null ? chef.getChef_fblink() : existingChef.getChef_fblink());
        existingChef.setChef_linkdin(chef.getChef_linkdin() != null ? chef.getChef_linkdin() : existingChef.getChef_linkdin());
        existingChef.setChef_image(chef.getChef_image() != null ? chef.getChef_image() : existingChef.getChef_image());
        existingChef.setChef_paymode(chef.getChef_paymode() != null ? chef.getChef_paymode() : existingChef.getChef_paymode());
        existingChef.setChef_state(chef.getChef_state() != null ? chef.getChef_state() : existingChef.getChef_state());
        existingChef.setChef_street(chef.getChef_street() != null ? chef.getChef_street() : existingChef.getChef_street());
        existingChef.setChef_zip(chef.getChef_zip() != null ? chef.getChef_zip() : existingChef.getChef_zip());
        existingChef.setChef_city(chef.getChef_city() != null ? chef.getChef_city() : existingChef.getChef_city());
        existingChef.setChef_experience(chef.getChef_experience() != 0 ? chef.getChef_experience() : existingChef.getChef_experience());
        return chefRepository.save(existingChef);

    }*/
   public Chef updateChef(ChefRequest chefRequest) {
       Chef existingChef = (Chef) chefRepository.findByLoginid(chefRequest.getLogin_id()).orElse(null);
       existingChef.setChef_fname(chefRequest.getChef_fname() != null ? chefRequest.getChef_fname() : existingChef.getChef_fname());
       existingChef.setChef_lname(chefRequest.getChef_lname() != null ? chefRequest.getChef_lname() : existingChef.getChef_lname());
       existingChef.setChef_phone(chefRequest.getChef_phone() != null ? chefRequest.getChef_phone() : existingChef.getChef_phone());
       existingChef.setChef_city(chefRequest.getChef_city() != null ? chefRequest.getChef_city() : existingChef.getChef_city());
       existingChef.setChef_description(chefRequest.getChef_description() != null ? chefRequest.getChef_description() : existingChef.getChef_description());
       existingChef.setChef_fblink(chefRequest.getChef_fblink() != null ? chefRequest.getChef_fblink() : existingChef.getChef_fblink());
       existingChef.setChef_linkdin(chefRequest.getChef_linkdin() != null ? chefRequest.getChef_linkdin() : existingChef.getChef_linkdin());
       existingChef.setChef_image(chefRequest.getChef_image() != null ? chefRequest.getChef_image() : existingChef.getChef_image());
       existingChef.setChef_paymode(chefRequest.getChef_paymode() != null ? chefRequest.getChef_paymode() : existingChef.getChef_paymode());
       existingChef.setChef_state(chefRequest.getChef_state() != null ? chefRequest.getChef_state() : existingChef.getChef_state());
       existingChef.setChef_street(chefRequest.getChef_street() != null ? chefRequest.getChef_street() : existingChef.getChef_street());
       existingChef.setChef_zip(chefRequest.getChef_zip() != null ? chefRequest.getChef_zip() : existingChef.getChef_zip());
       existingChef.setChef_city(chefRequest.getChef_city() != null ? chefRequest.getChef_city() : existingChef.getChef_city());
       existingChef.setChef_experience(chefRequest.getChef_experience() != 0 ? chefRequest.getChef_experience() : existingChef.getChef_experience());
       return chefRepository.save(existingChef);

   }

    /*public void getJson(String chef, MultipartFile chef_image) throws Exception {
        Chef chefJson = new Chef();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            chefJson = objectMapper.readValue(chef, Chef.class);
        } catch (IOException err)
        {
            //return "error";
            System.out.printf("error", err.toString());
        }
        Optional<UserCredentials> userData = userCredentialsRepository.findByEmail(chefJson.getChef_emailid());
        if (!userData.isPresent())
            throw new Exception("user Id doesn't exist");
        Long loginId = userData.get().getId();

        chefJson.setLogin_id(loginId);
        String fileName = StringUtils.cleanPath(chef_image.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a a valid file");
        }
        try {
            chefJson.setChef_image(Base64.getEncoder().encodeToString(chef_image.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        chefRepository.save(chefJson);

    }*/
}




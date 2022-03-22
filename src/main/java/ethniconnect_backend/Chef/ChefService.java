package ethniconnect_backend.Chef;

import ethniconnect_backend.UserCredentials.UserCredentialsRepository;
import ethniconnect_backend.UserCredentials.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChefService {
    @Autowired
    private ChefRepository chefProfileRepository;
    @Autowired
    private UserCredentialsRepository appUserRepository;

    public Chef saveChef(Chef chef) throws Exception{
        Optional<UserCredentials> userData =appUserRepository.findByEmail(chef.getChef_emailid());
        if(!userData.isPresent())
            throw new Exception("user Id doesn't exist");
        Long loginId = userData.get().getId();

        chef.setLogin_id(loginId);
        return chefProfileRepository.save(chef);
    }
    public List<Chef> saveChefs(List<Chef> chefs){
        return chefProfileRepository.saveAll(chefs);
    }

    public List<Chef> getChefs()
    {
        return chefProfileRepository.findAll();
    }
    public Chef getChefById(int chef_id){
        return chefProfileRepository.findById(chef_id).orElse(null);
    }
    /*public Chef getChefByEmailId(String chef_emailid){
        return chefProfileRepository.findByEmailId(chef_emailid);
    }*/
    public String deleteChef(int chef_id)
    {
        chefProfileRepository.deleteById(chef_id);
        return "chef removed !!" + chef_id;
    }
    public Chef updateChef(Chef chef)
    {
        Chef existingChef=chefProfileRepository.findById(chef.getChef_id()).orElse(null);
        existingChef.setChef_fname(chef.getChef_fname());
        existingChef.setChef_lname(chef.getChef_lname());
        existingChef.setChef_phone(chef.getChef_phone());
        existingChef.setChef_city(chef.getChef_city());
        existingChef.setChef_description(chef.getChef_description());
        existingChef.setChef_fblink(chef.getChef_fblink());
        existingChef.setChef_linkdin(chef.getChef_linkdin());
        existingChef.setChef_image(chef.getChef_image());
        existingChef.setChef_paymode(chef.getChef_paymode());
        existingChef.setChef_state(chef.getChef_state());
        existingChef.setChef_street(chef.getChef_street());
        existingChef.setChef_zip(chef.getChef_zip());
        existingChef.setChef_city(chef.getChef_city());
        existingChef.setChef_experience(chef.getChef_experience());
        return chefProfileRepository.save(existingChef);

    }
}

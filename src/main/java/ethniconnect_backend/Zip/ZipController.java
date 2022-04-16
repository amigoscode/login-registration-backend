package ethniconnect_backend.Zip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin()
@RestController
public class ZipController {
    @Autowired
    ZipService zipService;
    @GetMapping(path = "/getAllZip/")
    public List<Zip> getAllZip(){
       return zipService.getAllZip();

    }
    @GetMapping(path = "/getCuisinesByZip/{zipCode}")
    public Zip getCuisinesByZip(@PathVariable int zipCode){
        return zipService.getCuisineByZipCode(zipCode);

    }

}

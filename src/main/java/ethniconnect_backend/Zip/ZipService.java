package ethniconnect_backend.Zip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZipService {
    @Autowired
    ZipRepository zipRepository;
    public List<Zip> getAllZip(){
       return zipRepository.findAll();
    }

    public Zip getCuisineByZipCode(int zipCode){
        return zipRepository.getZipByZipCode(zipCode);
    }
}

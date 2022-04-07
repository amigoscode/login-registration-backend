package ethniconnect_backend.Zip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ZipController {
    @Autowired
    ZipService zipService;
    public List<Zip> getAllZip(){
       return zipService.getAllZip();

    }
}

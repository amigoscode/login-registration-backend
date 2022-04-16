package ethniconnect_backend.Zip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Root {
    public ArrayList<ZipCode> zip_codes;
}

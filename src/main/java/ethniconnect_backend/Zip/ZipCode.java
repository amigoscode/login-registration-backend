package ethniconnect_backend.Zip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZipCode {
    private String zip_code;
    private Integer distance;
    private String city;
    private String state;

}

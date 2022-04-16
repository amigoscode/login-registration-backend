package ethniconnect_backend.ChefDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChefprofileResponse {
    private String chef_name;
    private int menu_item_price;
}

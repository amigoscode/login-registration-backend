package ethniconnect_backend.Order;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class OrderSummaryEmail {

    @Override
    public String toString() {
        return
                " itemname='" + itemname + '\'' +
                "quantity=" + quantity +
                ", specialInstructions='" + specialInstructions + '\'' +
                ", totalPrice=" + totalPrice;
    }

    private int quantity;
    private String itemname;
    private String specialInstructions;
    private double totalPrice;
}

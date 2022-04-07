package ethniconnect_backend.Cart;

import ethniconnect_backend.ChefCreateMenu.ChefMenu;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
public class CartDto {
    private int id;
    private @NonNull long login_id;
    private @NonNull int quantity;
    private @NonNull ChefMenu menuItem;

    public CartDto() {
    }

    public CartDto(Cart cart) {
        this.setId(cart.getId());
        this.setLoginId(cart.getLoginId());
        this.setQuantity(cart.getQuantity());
        this.setMenuItem(cart.getMenuItem());
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", login_id=" + login_id +
                ", quantity=" + quantity +
                ", productName=" + menuItem.getItem_name() +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getLoginID() {
        return login_id;
    }

    public void setLoginId(long login_id) {
        this.login_id = login_id;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public ChefMenu getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(ChefMenu menuItem) {
        this.menuItem = menuItem;
    }


}

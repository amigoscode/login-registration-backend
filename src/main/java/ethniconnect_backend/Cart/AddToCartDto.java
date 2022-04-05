package ethniconnect_backend.Cart;

import com.sun.istack.NotNull;
import lombok.NonNull;

public class AddToCartDto {
    private int id;
    private @NotNull long login_id;
    private @NotNull int menu_id;
    private @NotNull int quantity;

    public AddToCartDto() {
    }

    public AddToCartDto(int id, @NotNull long login_id, @NotNull int menu_id, @NotNull int quantity) {
        this.id = id;
        this.login_id = login_id;
        this.menu_id = menu_id;
        this.quantity = quantity;
    }

    public AddToCartDto(Cart cart) {
        this.setId(cart.getId());
        this.setMenuId(cart.getMenuId());
        this.setLoginId(cart.getLogin_id());
        this.setQuantity(cart.getQuantity());
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", login_id=" + login_id +
                ", menu_id=" + menu_id +
                ", quantity=" + quantity +
                ",";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getLongId() {
        return login_id;
    }

    public void setLoginId(long login_id) {
        this.login_id = login_id;
    }

    public int getMenuId() {
        return menu_id;
    }

    public void setMenuId(int menu_id) {
        this.menu_id = menu_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

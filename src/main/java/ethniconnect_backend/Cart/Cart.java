package ethniconnect_backend.Cart;

import ethniconnect_backend.ChefCreateMenu.ChefMenu;
import ethniconnect_backend.ChefDetails.Chef;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cart")
public class Cart {

   @Id
   @GeneratedValue
    private int id;

    @Column(name = "login_id")
    private @NonNull long login_id;

    @Column(name = "menu_id")
    private @NonNull int menu_id;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ChefMenu menuItem;
    private int quantity;
    public Cart(AddToCartDto addToCartDto, long login_id) {
    }


    public Cart(CartDto cartDto, ChefMenu menuItem,long login_id){
        this.login_id = login_id;
        this.menu_id = cartDto.getMenuItem().getId();
        this.quantity = cartDto.getQuantity();
        this.menuItem = menuItem;
        this.createdDate = new Date();
    }

    public Cart(@NonNull long login_id, @NonNull int menu_id, int quantity) {
        this.login_id = login_id;
        this.menu_id = menu_id;
        this.createdDate = new Date();
        this.quantity = quantity;
    }

    public Cart(CartDto cartDto, ChefMenu menuItem) {
        this.menu_id = cartDto.getMenuItem().getId();
        this.quantity = cartDto.getQuantity();
        this.menuItem = menuItem;
        this.createdDate = new Date();
    }



    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getLoginId() {
        return login_id;
    }

    public void setLoginId(long login_id) {
        this.login_id = login_id;
    }

    public int getMenuId() {
        return menu_id;
    }

    public void setMenuID(int menu_id) {
        this.menu_id = menu_id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public ChefMenu getMenuItem() {
        return menuItem;
    }

    public void setProduct(ChefMenu menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}



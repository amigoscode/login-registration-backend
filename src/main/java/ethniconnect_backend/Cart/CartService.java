package ethniconnect_backend.Cart;

import ethniconnect_backend.ChefCreateMenu.ChefMenu;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addToCart(AddToCartDto addToCartDto,long login_id)
    {
        Cart cart = getAddToCartFromDto(addToCartDto,login_id);
        cartRepository.save(cart);
    }

    private Cart getAddToCartFromDto(AddToCartDto addToCartDto, long login_id)
    {
        final Cart cart = new Cart(addToCartDto, login_id);
        return cart;
    }

    public CartCost listCartItems(long login_id) {
        List<Cart> cartList = cartRepository.findAllByLoginIdOrderByCreatedDateDesc(login_id);
        List<CartDto> cartItems = new ArrayList<>();
        for (Cart cart:cartList){
            CartDto cartDto = getDtoFromCart(cart);
            cartItems.add(cartDto);
        }
        double totalCost = 0;
        for (CartDto cartDto:cartItems){
            totalCost += (cartDto.getMenuItem().getMenu_item_price()* cartDto.getQuantity());
        }
        CartCost cartCost = new CartCost(cartItems,totalCost);
        return cartCost;
    }


    public static CartDto getDtoFromCart(Cart cart) {
        CartDto cartDto = new CartDto(cart);
        return cartDto;
    }


    public void updateCartItem(AddToCartDto cartDto, long login_id, ChefMenu menuItem){
        Cart cart = getAddToCartFromDto(cartDto,login_id);
        cart.setQuantity(cartDto.getQuantity());
        cart.setLogin_id(login_id);
        cart.setId(cartDto.getId());
        cart.setMenu_id(menuItem.getId());
        cart.setCreatedDate(new Date());
        cartRepository.save(cart);
    }

    public void deleteCartItem(int id,long login_id) throws Exception {
        if (!cartRepository.existsById(id))
            throw new Exception("Cart id is invalid : " + id);
        cartRepository.deleteById(id);

    }


}

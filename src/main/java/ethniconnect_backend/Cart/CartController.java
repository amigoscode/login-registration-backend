package ethniconnect_backend.Cart;

import ethniconnect_backend.ChefCreateMenu.ChefMenuService;
import ethniconnect_backend.CustomerDetails.CustomerRepository;
import ethniconnect_backend.CustomerDetails.CustomerService;
import ethniconnect_backend.UserCredentials.UserCredentials;
import ethniconnect_backend.UserCredentials.UserCredentialsRepository;
import ethniconnect_backend.UserCredentials.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private ChefMenuService chefMenuService;



    @Autowired
    private UserCredentialsService userCredentialsService;
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @PostMapping("/add")
    public String addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam("login_id") long login_id) throws Exception {
        if(userCredentialsRepository.existsById(login_id))
            cartService.addToCart(addToCartDto,login_id);
        return  "Added to cart";

    }
    @GetMapping("/")
    public ResponseEntity<CartCost> getCartItems(long login_id) throws Exception {
        //if(userCredentialsRepository.existsById(login_id))
            CartCost cartCost = cartService.listCartItems(login_id);
        return new ResponseEntity<CartCost>(cartCost, HttpStatus.OK);
    }
    /*@PutMapping("/update/{cartItemId}")
    public ResponseEntity<ApiResponse> updateCartItem(@RequestBody @Valid AddToCartDto cartDto,
                                                      @RequestParam("token") String token) throws AuthenticationFailException,ProductNotExistException {
        authenticationService.authenticate(token);
        int userId = authenticationService.getUser(token).getId();

        Product product = productService.getProductById(cartDto.getProductId());

        cartService.updateCartItem(cartDto,userId,product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemID,@RequestParam("token") String token) throws AuthenticationFailException, CartItemNotExistException {
        authenticationService.authenticate(token);

        int userId = authenticationService.getUser(token).getId();

        cartService.deleteCartItem(itemID,userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }
*/
}

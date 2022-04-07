package ethniconnect_backend.Order;

import ethniconnect_backend.Cart.CartDto;
import ethniconnect_backend.Cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

      /*  @Autowired
        private OrderRepository orderRepository;

        @Autowired
        private CartService cartService;

        @Autowired
        OrderItemsService orderItemsService;

        public void placeOrder(long login_id) {
            CartDto cartDto = cartService.listCartItems(login_id);

            PlaceOrderRequest placeOrderRequest = new PlaceOrderRequest();
            placeOrderRequest.setLogin_id(login_id);
            placeOrderRequest.setOrder_amount(cartDto.getTotalCost());

            int orderId = saveOrder(placeOrderRequest, login_id);
            List<CartItemDto> cartItemDtoList = cartDto.getcartItems();
            for (CartItemDto cartItemDto : cartItemDtoList) {
                OrderItem orderItem = new OrderItem(
                        orderId,
                        cartItemDto.getProduct().getId(),
                        cartItemDto.getQuantity(),
                        cartItemDto.getProduct().getPrice());
                orderItemsService.addOrderedProducts(orderItem);
            }
            cartService.deleteCartItems(userId);
        }

        public int saveOrder(PlaceOrderRequest orderDto, long login_id){
            Order order = getOrderFromDto(orderDto,login_id);
            return orderRepository.save(order).getId();
        }

        private Order getOrderFromDto(PlaceOrderRequest orderDto, long login_id) {
            Order order = new Order(orderDto,login_id);
            return order;
        }

        public List<Order> listOrders(long login_id) {
            List<Order> orderList = orderRepository.findAllByLogin_idOrderByCreatedDateDesc(login_id);
            return orderList;
        }*/
}

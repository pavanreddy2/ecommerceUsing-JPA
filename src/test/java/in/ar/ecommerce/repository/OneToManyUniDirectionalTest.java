package in.ar.ecommerce.repository;

import in.ar.ecommerce.entity.Address;
import in.ar.ecommerce.entity.Order;
import in.ar.ecommerce.entity.OrderItem;
import in.ar.ecommerce.entity.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToManyUniDirectionalTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;


    @Test
    void saveOrderMethod() {
        Order order = new Order();
        order.setOrderTrackingNumber("100ABC");
        order.setStatus(Status.INPROGRESS);

        //Create Order Item 1
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProduct(productRepository.findById(5L).get());
        orderItem1.setQuantity(2);
        orderItem1.setPrice(orderItem1.getProduct().getPrice().multiply(new BigDecimal(2)));
        orderItem1.setImageUrl("image1.png");
        order.getOrderItems().add(orderItem1);

        //Create Order Item 2
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct(productRepository.findById(6L).get());
        orderItem2.setQuantity(3);
        orderItem2.setPrice(orderItem1.getProduct().getPrice().multiply(new BigDecimal(3)));
        orderItem2.setImageUrl("image2.png");
        order.getOrderItems().add(orderItem2);

        order.setTotalPrice(order.getTotalAmount());
        order.setTotalQuantity(2);

        //Address
        Address address = new Address();
        address.setStreet("MathruShree");
        address.setCity("Hyderabad");
        address.setState("Telangana");
        address.setCountry("INDIA");
        address.setPinCode("500122");

        order.setBillingAddresses(address);

        orderRepository.save(order);
    }

    @Test
    void fetchOrderMethod() {
       Order order = orderRepository.findById(1L).get();
        System.out.println(order.toString());
       for (OrderItem orderItem: order.getOrderItems()) {
           System.out.println(orderItem.getProduct().getName());
       }
    }

    @Test
    void deleteOrderMethod(){
        orderRepository.deleteById(1L);
    }
}

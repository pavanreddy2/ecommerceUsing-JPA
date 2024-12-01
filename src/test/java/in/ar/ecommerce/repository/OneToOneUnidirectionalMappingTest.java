package in.ar.ecommerce.repository;

import in.ar.ecommerce.entity.Address;
import in.ar.ecommerce.entity.Order;
import in.ar.ecommerce.entity.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneUnidirectionalMappingTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveOrderDetailsTest() {
        Order order = new Order();
        order.setOrderTrackingNumber("1000A");
        order.setTotalQuantity(2);
        order.setTotalPrice(new BigDecimal(1000));
        order.setStatus(Status.INPROGRESS);

        Address address = new Address();
        address.setStreet("Miyapur");
        address.setCity("Hyderabad");
        address.setState("Telangana");
        address.setCountry("INDIA");
        address.setPinCode("500192");

        order.setBillingAddresses(address);
        orderRepository.save(order);
    }

    @Test
    void getOrderDetailsTest() {
        Order order = orderRepository.findById(2L).get();
        System.out.println(order);
    }

    @Test
    void updateOrderDetailsTest() {
        Order order = orderRepository.findById(1L).get();
        order.setStatus(Status.DELIVERED);
        order.getBillingAddresses().setPinCode("500034");
        orderRepository.save(order);
    }

    @Test
    void deleteOrderDetailsTest() {
        orderRepository.deleteById(1L);
    }

}

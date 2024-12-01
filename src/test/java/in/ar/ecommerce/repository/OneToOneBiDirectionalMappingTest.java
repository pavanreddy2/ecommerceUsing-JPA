package in.ar.ecommerce.repository;

import in.ar.ecommerce.entity.Address;
import in.ar.ecommerce.entity.Order;
import in.ar.ecommerce.entity.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneBiDirectionalMappingTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void saveAddressMethodTest(){
        Order order = new Order();
        order.setOrderTrackingNumber("1000B");
        order.setTotalQuantity(12);
        order.setTotalPrice(new BigDecimal(2200));
        order.setStatus(Status.INPROGRESS);

        Address address = new Address();
        address.setStreet("MathruShree");
        address.setCity("Hyderabad");
        address.setState("Telangana");
        address.setCountry("INDIA");
        address.setPinCode("500122");

        order.setBillingAddresses(address);
        address.setOrder(order);
        addressRepository.save(address);
    }



    //Delete
    @Test
    void deleteAddressMethodTest(){
        addressRepository.deleteById(1L);
    }

}

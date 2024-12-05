package in.ar.ecommerce.repository;

import in.ar.ecommerce.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class ProductTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveProductTest() {
        Product product1 = new Product();
        product1.setSku("114ABCD");
        product1.setName("product 1");
        product1.setDescription("Product 1 description");
        product1.setPrice(new BigDecimal(100));
        product1.setActice(true);
        product1.setImageUrl("product1.png");

        Product product2 = new Product();
        product2.setSku("114EDGC");
        product2.setName("product 2");
        product2.setDescription("Product 2 description");
        product2.setPrice(new BigDecimal(1700));
        product2.setActice(true);
        product2.setImageUrl("product2.png");

        productRepository.saveAll(List.of(product1,product2));
    }
}

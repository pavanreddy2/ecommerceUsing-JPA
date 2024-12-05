
package in.ar.ecommerce.repository;

import in.ar.ecommerce.entity.Product;
import in.ar.ecommerce.entity.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
public class ProductCategoryOneToManyTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    void saveProductCategory(){
        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setCategoryName("Book");
        productCategory1.setGetCategoryDescription("Book Description.");

        Product product = new Product();
        product.setName("Core Java");
        product.setPrice(new BigDecimal(1000));
        product.setImageUrl("image.png");
        product.setSku("ABC");
        product.setActice(true);
        product.setProductCategory(productCategory1);

        productCategory1.getProducts().add(product);

        //Product 2
        Product product2 = new Product();
        product2.setName("Core Java using Springboot");
        product2.setPrice(new BigDecimal(10010));
        product2.setImageUrl("image1.png");
        product2.setSku("ABCD");
        product2.setActice(true);
        product2.setProductCategory(productCategory1);

        productCategory1.getProducts().add(product2);

        productCategoryRepository.save(productCategory1);
    }

/*    @Test
    @Transactional
    void fetchProducts() {
        Optional<ProductCategory> id = productCategoryRepository.findById(1L);
        if(id.isPresent()){
            System.out.println(id.get());
        }
    }*/
}

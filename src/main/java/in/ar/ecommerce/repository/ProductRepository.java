package in.ar.ecommerce.repository;

import in.ar.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    //JPQL
    @Query("select p from Product p where " +
            "p.name LIKE CONCAT('%',:query,'%')" +
            "OR p.description LIKE CONCAT('%', :query, '%')")
    List<Product> searchProducts(String query);

    //Native SQL QUERY
    @Query(value = "select * from Products p where " +
            "p.name LIKE CONCAT('%',:query,'%')" +
            "OR p.description LIKE CONCAT('%', :query, '%')",nativeQuery = true)
    List<Product> searchProductSQL(String query);
}

package in.ar.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    private String getCategoryDescription;

    @OneToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE
        }, fetch = FetchType.LAZY,mappedBy = "productCategory")
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();
}

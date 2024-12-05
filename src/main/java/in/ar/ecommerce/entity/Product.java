package in.ar.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.YesNoConverter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products",
        schema = "ecommerce",
        uniqueConstraints = {
        @UniqueConstraint(
                name = "sku_unique",
                columnNames = "sku"
        )
        })
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "stoke_keeping_unit", nullable = false)
    private String sku;   //Stock Keeping Unit

    @Column(nullable = false, length = 255)
    private String name;
    private String description;
    private BigDecimal price;
    @Convert(converter = YesNoConverter.class)
    private boolean actice;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @ManyToOne
    @JoinColumn(name="category_id", referencedColumnName = "id")
    @JsonBackReference
    private ProductCategory productCategory;
}

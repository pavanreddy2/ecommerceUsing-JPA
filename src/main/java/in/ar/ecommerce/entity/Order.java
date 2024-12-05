package in.ar.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders",
        uniqueConstraints = {@UniqueConstraint(columnNames = "orderTrackingNumber")})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private String orderTrackingNumber;
    private int totalQuantity;
    private BigDecimal totalPrice;
    @Enumerated(EnumType.STRING)
    private Status status;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    //Unidirectional
    //@JoinColumn(name = "billing_address_id", referencedColumnName = "id")
    private Address billingAddresses;

    //UniDirectional
    //Default fetch Type for one to many is LAZY
    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "order_id", referencedColumnName = "orderId")
    //Bidirectional
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "order")
    private Set<OrderItem> orderItems = new HashSet<>();

    //Total Amount calculation
    public BigDecimal getTotalAmount() {
        BigDecimal amount = new BigDecimal(0.0);
        for (OrderItem item: this.orderItems){
            amount = amount.add(item.getPrice());
        }
        return amount;
    }
}


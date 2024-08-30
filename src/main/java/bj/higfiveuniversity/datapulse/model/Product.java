package bj.higfiveuniversity.datapulse.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "product")
    List<OrderItem> orderItems;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "stock_quantity", nullable = false)
    private Double stockQuantity;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // une categorie peut contenir plusieurs produits
    @ManyToMany
    @JoinTable(
        name="category_product",
        joinColumns=@JoinColumn(name="category_id"),
        inverseJoinColumns =@JoinColumn(name ="product_id")
    )

    private List<Category> categories;

    
    // s'execute quand on insert une donnée
    @PrePersist
    protected void onCreate(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    // s'execute quand on modifie une donnée
    @PreUpdate
    protected void onUpdate(){
        updatedAt =  LocalDateTime.now();

    }
}

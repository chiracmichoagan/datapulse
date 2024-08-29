package bj.higfiveuniversity.datapulse.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="products")
public class Product {
@Id
@GeneratedValue
 private Long id; 

 @Column(nullable=false)
 private String name;

 @Column(nullable=false)
 private double price;

 @Column(columnDefinition="TEXT")
 private String description;

 @Column(name="stock_quantity", nullable=false)
 private Double stockQuantity;
 
 @Column(updatable=false)
 private LocalDateTime created_at;

 private LocalDateTime updated_at;
}

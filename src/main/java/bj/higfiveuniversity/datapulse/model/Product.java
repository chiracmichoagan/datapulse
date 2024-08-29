package bj.higfiveuniversity.datapulse.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
@Id
@GeneratedValue
 private Long id; 
 private String name;
 private double price;
 private String description;
 private Double stockQuantity; 
 private LocalDateTime created_at;
 private LocalDateTime updated_at;
}

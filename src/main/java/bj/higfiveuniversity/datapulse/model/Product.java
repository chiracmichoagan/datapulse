package bj.higfiveuniversity.datapulse.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
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

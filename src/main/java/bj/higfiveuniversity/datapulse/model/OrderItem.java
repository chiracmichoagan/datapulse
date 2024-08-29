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
@Table(name="order_items")
public class OrderItem { 
@Id
@GeneratedValue
private Long id ;  
//Todo:: créer la clé primaire order-id;
//Todo:: crer la clé secondaire product_id
@Column(nullable=false)
private Double quantity;

@Column(nullable=false)
private Double price;

@Column(updatable=false)
private LocalDateTime created_at;
private LocalDateTime updated_at;


}
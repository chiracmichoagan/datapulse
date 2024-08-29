package bj.higfiveuniversity.datapulse.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem { 
@Id
@GeneratedValue
 
private Long id ;  
//Todo:: créer la clé primaire order-id;
//Todo:: crer la clé secondaire product_id
private Double quantity;
private Double price;   
private LocalDateTime created_at;
private LocalDateTime updated_at;


}
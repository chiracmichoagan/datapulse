package bj.higfiveuniversity.datapulse.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Order {
@Id
@GeneratedValue
private Long id;       
private Long userId;  // Todo: ajouter le user-id;
private Double totalAmount;
private String status;
private LocalDateTime created_at;
private LocalDateTime updated_at;

}

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
@Table(name = "orders")
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

package bj.higfiveuniversity.datapulse.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="orders")
public class Order {
@Id
@GeneratedValue
private Long id;

 @ManyToOne
 @JoinColumn(name ="user_id", nullable = false)
 private User user;

@OneToMany(mappedBy="order")
List<OrderItem> ordersItems;

@Column(nullable = false)
private Double totalAmount;

@Column(nullable = false)
private String status;

@Column(nullable =false, updatable = false)
private LocalDateTime createdAt;

private LocalDateTime updatedAt;


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

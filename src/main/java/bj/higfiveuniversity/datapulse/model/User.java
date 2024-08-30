package bj.higfiveuniversity.datapulse.model;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
// import lombok.AllArgsConstructor;
// import lombok.EqualsAndHashCode;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.RequiredArgsConstructor;
// import lombok.Setter;
// import lombok.ToString;
import lombok.NoArgsConstructor;

import java.util.List;

import jakarta.persistence.OneToMany;
/* 
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
*/
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;


@AllArgsConstructor
@NoArgsConstructor
@Builder   //creer un intance ...
@Entity  //le model va representé une table dans notre base de données
@Data     // representer getter & setter & autres
@Table(name="users")
public class User {
     @Id
     @GeneratedValue
    private Long id;

    @Column(nullable=false, unique=true)
    private String username;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String password;

    @Column(nullable =false, updatable=false)
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user")
   private List<Order> orders;

   
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
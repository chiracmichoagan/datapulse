package bj.higfiveuniversity.datapulse.model;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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

/* 
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
*/


@Builder   //creer un intance ...
@Data     // representer getter & setter & autres
@AllArgsConstructor
@NoArgsConstructor
@Entity  //le model va representé une table dans notre base de données
public class User {
     @Id
     @GeneratedValue
    private Long id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
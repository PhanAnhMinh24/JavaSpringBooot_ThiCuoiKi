package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Long id;

    String username;

    String password;

    String email;

    @Column(name = "full_name")
    String fullName;

    @Column(name = "phone_number")
    String phoneNumber;

    @OneToMany(mappedBy = "user")
    List<Address> address;

    @Column(name = "profile_image")
    String profileImage;

    @OneToOne
    @JoinColumn(name = "role_id")
    Role role;
}

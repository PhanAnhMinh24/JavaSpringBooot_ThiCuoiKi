package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String description;

    @Column(name = "is_default")
    Boolean isDefault;

    @OneToOne(mappedBy = "role")
    private User user;
}

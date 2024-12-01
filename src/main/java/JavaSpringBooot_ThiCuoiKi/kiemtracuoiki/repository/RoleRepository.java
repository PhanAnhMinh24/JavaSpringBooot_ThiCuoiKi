package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.repository;

import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);

    Role findByIsDefaultTrue();
}

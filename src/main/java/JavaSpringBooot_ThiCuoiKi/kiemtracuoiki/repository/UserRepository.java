package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.repository;

import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);  // Sử dụng phương thức này vì email đã được thêm vào User
}

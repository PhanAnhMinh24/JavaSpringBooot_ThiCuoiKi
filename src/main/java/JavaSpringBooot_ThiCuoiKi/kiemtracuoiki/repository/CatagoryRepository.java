package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.repository;

import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatagoryRepository extends JpaRepository<Categories, Long> {
}

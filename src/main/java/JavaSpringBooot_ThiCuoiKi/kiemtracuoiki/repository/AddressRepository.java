package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.repository;

import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {


}

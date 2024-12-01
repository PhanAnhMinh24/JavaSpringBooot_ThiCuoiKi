package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.service.role;

import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.entity.Role;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleDefault() {
        return roleRepository.findByIsDefaultTrue();
    }
}

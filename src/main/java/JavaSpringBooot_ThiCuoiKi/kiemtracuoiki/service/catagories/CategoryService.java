package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.service.catagories;

import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.response.catagories.CatagoryResponse;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.repository.CatagoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CatagoryRepository catagoryRepository;

    @Override
    public List<CatagoryResponse> getAll() {
        return catagoryRepository.findAll().stream()
                .map(item -> {
                    return CatagoryResponse.builder()
                            .id(item.getCategoryId())
                            .name(item.getName())
                            .build();
                }).toList();
    }
}

package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.service.catagories;

import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.response.catagories.CatagoryResponse;

import java.util.List;

public interface ICategoryService {

    List<CatagoryResponse> getAll();

}

package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.controller;


import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.ApiResult;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.response.catagories.CatagoryResponse;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.service.catagories.ICategoryService;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.utils.constants.EndpointConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = EndpointConstants.CATEGORIES)
public class CategoriesController {
    private final ICategoryService catagoryService;

    public CategoriesController(ICategoryService catagoryService) {
        this.catagoryService = catagoryService;
    }

    @GetMapping
    public ResponseEntity<ApiResult<List<CatagoryResponse>>> getAll() {
        return ResponseEntity.ok().body(ApiResult.success(catagoryService.getAll()));
    }


}

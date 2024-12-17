package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.response.catagories;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CatagoryResponse {
    Long id;
    String name;
}

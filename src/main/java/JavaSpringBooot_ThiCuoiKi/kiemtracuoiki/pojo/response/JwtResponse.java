package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtResponse {
    String token;
    String username;
    String type;
}

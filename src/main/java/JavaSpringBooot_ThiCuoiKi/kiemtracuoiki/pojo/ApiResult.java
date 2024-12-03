package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo;

import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.utils.constants.CommonConstants;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResult<T> {
    T results;
    String message;
    HttpStatus httpStatus;

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(data, CommonConstants.SUCCESS, HttpStatus.OK);
    }

    public static <T> ApiResult<T> success(T data, String message) {
        return new ApiResult<>(data, message, HttpStatus.OK);
    }
}

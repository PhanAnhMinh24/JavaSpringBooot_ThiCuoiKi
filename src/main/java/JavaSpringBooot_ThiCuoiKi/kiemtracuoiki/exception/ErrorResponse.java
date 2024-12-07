package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ErrorResponse {
    String message;

    public static ErrorResponse form(String message){
        return new ErrorResponse(message);
    }
}

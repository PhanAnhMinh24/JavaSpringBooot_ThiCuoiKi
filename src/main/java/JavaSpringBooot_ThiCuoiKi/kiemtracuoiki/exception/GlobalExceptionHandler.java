package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.exception;

import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.ApiResult;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {
    //Bắt lỗi 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResult<ErrorCode>> handleUnwantedException(Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(500).body(ApiResult.error(ErrorCode.SYSTEM_ERROR));
    }

    // Bắt lỗi 400
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResult<ErrorCode>> handleBadRequestException(Exception e, ErrorCode errorCode) {
        log.info("Bad Request: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResult.error(errorCode));
    }
}

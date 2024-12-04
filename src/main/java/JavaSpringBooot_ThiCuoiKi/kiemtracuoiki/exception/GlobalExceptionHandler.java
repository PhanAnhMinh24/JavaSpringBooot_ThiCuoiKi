package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.exception;

import lombok.extern.log4j.Log4j2;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class GlobalExceptionHandler {
    //Bắt lỗi 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorCode> handleUnwantedException(Exception e) {
        log.info("Exception Request: {}", e.getMessage());
        return ResponseEntity.status(500).body(ErrorCode.SYSTEM_ERROR);
    }

    // Bắt lỗi 400
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException e) {
        log.info("Bad Request: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse.form(e.getMessage()));
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorResponse> handleAppException(AppException e) {
        log.info("Bad Request: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse.form(e.getMessage()));
    }
}

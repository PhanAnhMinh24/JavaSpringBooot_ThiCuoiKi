package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    SYSTEM_ERROR("system-error",HttpStatus.BAD_REQUEST),
    INVALID_USERNAME_OR_PASSWORD("invalid-username-or-password",HttpStatus.BAD_REQUEST),
    DURING_REGISTRATION_ERROR("during-registration-error",HttpStatus.BAD_REQUEST),
    ;

    private final String message;
    private final HttpStatus status;

    ErrorCode(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}

package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.controller;

import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.exception.AppException;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.exception.ErrorCode;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.ApiResult;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.request.LoginRequest;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.request.SignupRequest;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.response.JwtResponse;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.service.auth.AuthService;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.utils.JwtUtils;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.utils.constants.EndpointConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = EndpointConstants.AUTH)
public class AuthController {
    private final AuthService authService;
    private final JwtUtils jwtUtils;

    public AuthController(AuthService authService, JwtUtils jwtUtils) {
        this.authService = authService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping(value = EndpointConstants.SIGN_IN)
    public ResponseEntity<ApiResult<JwtResponse>> authenticateUser(@RequestBody LoginRequest loginRequest) {
        String token = authService.login(loginRequest);

        if (token == null) {
            throw new AppException(ErrorCode.INVALID_USERNAME_OR_PASSWORD);
        }

        return ResponseEntity.ok().body(ApiResult.success(new JwtResponse(token, loginRequest.getUsername(), "Bearer")));
    }

    @PostMapping(value = EndpointConstants.SIGN_UP)
    public ResponseEntity<ApiResult<String>> registerUser(@RequestBody SignupRequest signupRequest) {
        try {
            authService.registerUser(signupRequest);
            return ResponseEntity.ok().body(ApiResult.success("User registered successfully!"));
        } catch (Exception e) {
            throw new AppException(ErrorCode.DURING_REGISTRATION_ERROR);
        }
    }

}

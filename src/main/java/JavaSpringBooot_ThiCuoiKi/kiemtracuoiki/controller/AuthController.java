package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.controller;

import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.request.LoginRequest;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.request.SignupRequest;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.response.JwtResponse;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.response.MessageResponse;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.service.AuthService;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.utils.JwtUtils;


import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        String token = authService.login(loginRequest);

        if (token == null) {
            return ResponseEntity.badRequest().body(new MessageResponse("Invalid username or password!"));
        }

        return ResponseEntity.ok(new JwtResponse(token, loginRequest.getUsername(), "Bearer"));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
        try {
            authService.registerUser(signupRequest);
            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error during registration: " + e.getMessage()));
        }
    }

}

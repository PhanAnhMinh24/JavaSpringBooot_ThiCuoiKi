package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.service;

import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.entity.User;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.request.LoginRequest;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.request.SignupRequest;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.response.JwtResponse;

public interface IAuthService {
    User registerUser(SignupRequest signupRequest);

    JwtResponse login(LoginRequest loginRequest);
}

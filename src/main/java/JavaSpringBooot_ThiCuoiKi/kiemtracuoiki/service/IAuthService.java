package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.service;

import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.entity.User;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.request.LoginRequest;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.request.SignupRequest;

public interface IAuthService {
    User registerUser(SignupRequest signupRequest);

    String login(LoginRequest loginRequest);
}

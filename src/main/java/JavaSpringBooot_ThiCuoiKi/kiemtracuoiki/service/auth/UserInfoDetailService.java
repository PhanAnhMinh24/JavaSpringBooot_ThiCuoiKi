package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.service.auth;

import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.entity.User;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.exception.AppException;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.exception.ErrorCode;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userInfo = userRepository.findByEmail(username);
        if (userInfo == null) {
            throw new AppException(ErrorCode.SYSTEM_ERROR);
        }
        return new CustomUserDetails(userInfo);
    }
}

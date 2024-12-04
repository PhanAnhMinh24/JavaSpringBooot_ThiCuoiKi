package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.service.auth;

import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.entity.User;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.exception.AppException;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.exception.ErrorCode;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.request.LoginRequest;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.request.SignupRequest;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.repository.UserRepository;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.service.address.IAddressService;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.service.role.IRoleService;
import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.utils.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService implements IAuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final IRoleService roleService;
    private final IAddressService addressService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtils,
                       AuthenticationManager authenticationManager, IRoleService roleService, IAddressService addressService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.roleService = roleService;
        this.addressService = addressService;
    }

    // Phương thức đăng ký
    @Override
    public User registerUser(SignupRequest signupRequest) {
        User user = User.builder()
                .email(signupRequest.getEmail())
                .username(signupRequest.getUsername())
                .password(passwordEncoder.encode(signupRequest.getPassword())) // Mã hóa mật khẩu
                .fullName(signupRequest.getFullName())
                .role(roleService.getRoleDefault())
                .build();
        User userSave = userRepository.save(user); // Lưu người dùng vào cơ sở dữ liệu
        addressService.saveAddress(userSave, signupRequest.getAddress()); // Lưu địa chỉ khi đã lưu người dùng
        return userSave;
    }

    // Phương thức đăng nhập
    @Override
    public JwtResponse login(LoginRequest loginRequest) {
        try {  // Thực hiện xác thực người dùng
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );

            UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
            String jwt = jwtUtils.generateToken(userPrincipal.getEmail());

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(item -> item.getAuthority())
                    .collect(Collectors.toList());

            return new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getEmail(),
                    roles);
        } catch (Exception e) {
            throw new AppException(ErrorCode.INVALID_USERNAME_OR_PASSWORD);
        }
    }
}

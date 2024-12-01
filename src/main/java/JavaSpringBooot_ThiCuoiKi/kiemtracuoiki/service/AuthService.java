package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.service;

import JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.entity.User;
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
    public String login(LoginRequest loginRequest) {
        // Thực hiện xác thực người dùng
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        if (authentication.isAuthenticated()) {
            // Nếu xác thực thành công, tạo JWT token
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return jwtUtils.generateJwtToken(userDetails.getUsername());
        }

        return null; // Trả về null nếu xác thực thất bại
    }
}

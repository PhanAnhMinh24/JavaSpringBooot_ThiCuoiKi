package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.utils;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationMs}")
    private int jwtExpirationMs;

    // Generate JWT token from username
    public String generateJwtToken(String username) {
        return Jwts.builder()
                .setSubject(username)  // Đặt username làm subject
                .setIssuedAt(new Date())  // Đặt thời gian phát hành token
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))  // Đặt thời gian hết hạn
                .signWith(SignatureAlgorithm.HS512, jwtSecret)  // Dùng thuật toán HS512 và key bí mật để ký token
                .compact();  // Trả về token đã được tạo
    }

    // Validate the JWT token
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser()  // Sử dụng parser() thay vì parserBuilder()
                    .setSigningKey(jwtSecret)  // Đặt key bí mật để xác thực token
                    .parseClaimsJws(authToken);  // Kiểm tra xem token có hợp lệ không
            return true;
        } catch (SignatureException e) {
            System.out.println("Invalid JWT signature: " + e.getMessage());
        } catch (MalformedJwtException e) {
            System.out.println("Invalid JWT token: " + e.getMessage());
        } catch (ExpiredJwtException e) {
            System.out.println("JWT token is expired: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println("JWT token is unsupported: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("JWT claims string is empty: " + e.getMessage());
        }
        return false;  // Nếu gặp lỗi thì token không hợp lệ
    }

    // Get the username from JWT token
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()  // Sử dụng parser() thay vì parserBuilder()
                .setSigningKey(jwtSecret)  // Đặt key bí mật để xác thực token
                .parseClaimsJws(token)  // Giải mã token
                .getBody()  // Lấy payload (phần body)
                .getSubject();  // Trả về username
    }
}

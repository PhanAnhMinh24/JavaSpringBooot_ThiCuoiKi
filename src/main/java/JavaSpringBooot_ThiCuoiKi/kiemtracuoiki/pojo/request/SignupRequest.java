package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignupRequest {
    String username;
    String password;
    String email;
    String fullName;
    String phoneNumber;
    String address;
    String profileImage;
}

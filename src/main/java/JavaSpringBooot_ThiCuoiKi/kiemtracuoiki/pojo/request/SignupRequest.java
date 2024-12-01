package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
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
     String roleId;

}

package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.pojo.response;

public class JwtResponse {

    private String token;
    private String username;
    private String type;

    // Constructor với 3 tham số
    public JwtResponse(String token, String username, String type) {
        this.token = token;
        this.username = username;
        this.type = type;
    }

    // Getter và Setter
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

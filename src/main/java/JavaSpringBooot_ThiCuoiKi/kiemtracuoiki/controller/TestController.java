package JavaSpringBooot_ThiCuoiKi.kiemtracuoiki.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Message API")
public class TestController {
    @GetMapping("/message")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok().body("Hello, this is a GET request!");
    }
}

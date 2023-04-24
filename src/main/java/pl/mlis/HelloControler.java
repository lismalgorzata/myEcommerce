package pl.mlis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController; //kod java -> http

@RestController
public class HelloControler {
    @GetMapping("/hello")
    String hello() {
        return "Hello World";
    }
}

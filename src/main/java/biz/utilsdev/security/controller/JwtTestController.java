package biz.utilsdev.security.controller;

import biz.utilsdev.security.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test-jwt")
@RequiredArgsConstructor
public class JwtTestController {

    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping("/generate")
    public String generateToken(@RequestParam String username) {
        return jwtTokenProvider.generateToken(username);
    }

    @GetMapping("/validate")
    public boolean validateToken(@RequestParam String token) {
        return jwtTokenProvider.validateToken(token);
    }

    @GetMapping("/username")
    public String extractUsername(@RequestParam String token) {
        return jwtTokenProvider.getUsernameFromToken(token);
    }

}

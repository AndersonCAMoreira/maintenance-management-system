package com.anderson.backend.controller;

import com.anderson.backend.dto.LoginDTO;
import com.anderson.backend.repository.UsuarioRepository;
import com.anderson.backend.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public Map<String, String> login(@Valid @RequestBody LoginDTO loginDTO) {
        var usuario = usuarioRepository.findByLogin(loginDTO.getLogin())
            .orElseThrow(() -> new RuntimeException("Usuário ou senha inválidos"));

        if (!passwordEncoder.matches(loginDTO.getSenha(), usuario.getSenha())) {
            throw new RuntimeException("Usuário ou senha inválidos");
        }

        String token = jwtService.gerarToken(usuario.getLogin());
        return Map.of("token", token);
    }

}
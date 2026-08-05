package com.anderson.backend.config;

import com.anderson.backend.entity.Usuario;
import com.anderson.backend.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        String login = System.getenv("LEADER_LOGIN");
        String senha = System.getenv("LEADER_PASSWORD");

        if (usuarioRepository.findByLogin(login).isEmpty()) {
            Usuario usuario = new Usuario();
            usuario.setLogin(login);
            usuario.setSenha(passwordEncoder.encode(senha));
            usuarioRepository.save(usuario);
            System.out.println("Usuário líder criado: " + login);
        }
    }

}
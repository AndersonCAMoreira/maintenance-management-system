package com.anderson.backend.controller;

import com.anderson.backend.entity.Ativo;
import com.anderson.backend.repository.AtivoRepository;
import org.springframework.web.bind.annotation.*;
import com.anderson.backend.entity.StatusAtivo;

import java.util.List;

@RestController
@RequestMapping("/ativos")
public class AtivoController {

    private final AtivoRepository ativoRepository;

    public AtivoController(AtivoRepository ativoRepository) {
        this.ativoRepository = ativoRepository;
    }

    @PostMapping
    public Ativo criar(@RequestBody Ativo ativo) {
        return ativoRepository.save(ativo);
    }

    @GetMapping
    public List<Ativo> listar() {
        return ativoRepository.findAll();
    }

    @GetMapping("/operantes")
    public List<Ativo> listarOperantes() {
        return ativoRepository.findByStatus(StatusAtivo.OPERANTE);
    }

}
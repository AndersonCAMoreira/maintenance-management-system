package com.anderson.backend.controller;

import com.anderson.backend.dto.ManutencaoPreventivaDTO;
import com.anderson.backend.service.ManutencaoPreventivaService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manutencoes-preventivas")
public class ManutencaoPreventivaController {

    private final ManutencaoPreventivaService manutencaoPreventivaService;

    public ManutencaoPreventivaController(ManutencaoPreventivaService manutencaoPreventivaService) {
        this.manutencaoPreventivaService = manutencaoPreventivaService;
    }

    @PostMapping
    public ManutencaoPreventivaDTO criar(@Valid @RequestBody ManutencaoPreventivaDTO dto) {
        return manutencaoPreventivaService.criar(dto);
    }

    @GetMapping
    public List<ManutencaoPreventivaDTO> listar() {
        return manutencaoPreventivaService.listar();
    }

}
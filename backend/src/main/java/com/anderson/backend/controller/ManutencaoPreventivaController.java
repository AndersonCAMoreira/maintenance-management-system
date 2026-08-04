package com.anderson.backend.controller;

import com.anderson.backend.entity.ManutencaoPreventiva;
import com.anderson.backend.repository.ManutencaoPreventivaRepository;
import com.anderson.backend.service.ManutencaoPreventivaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manutencoes-preventivas")
public class ManutencaoPreventivaController {

    private final ManutencaoPreventivaService manutencaoPreventivaService;
    private final ManutencaoPreventivaRepository manutencaoPreventivaRepository;

    public ManutencaoPreventivaController(ManutencaoPreventivaService manutencaoPreventivaService, ManutencaoPreventivaRepository manutencaoPreventivaRepository) {
        this.manutencaoPreventivaService = manutencaoPreventivaService;
        this.manutencaoPreventivaRepository = manutencaoPreventivaRepository;
    }

    @PostMapping
    public ManutencaoPreventiva criar(@RequestBody ManutencaoPreventiva manutencaoPreventiva) {
        return manutencaoPreventivaService.salvar(manutencaoPreventiva);
    }

    @GetMapping
    public List<ManutencaoPreventiva> listar() {
        return manutencaoPreventivaRepository.findAll();
    }

}
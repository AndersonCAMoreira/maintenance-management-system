package com.anderson.backend.controller;

import com.anderson.backend.entity.ManutencaoPreventiva;
import com.anderson.backend.repository.ManutencaoPreventivaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manutencoes-preventivas")
public class ManutencaoPreventivaController {

    private final ManutencaoPreventivaRepository manutencaoPreventivaRepository;

    public ManutencaoPreventivaController(ManutencaoPreventivaRepository manutencaoPreventivaRepository) {
        this.manutencaoPreventivaRepository = manutencaoPreventivaRepository;
    }

    @PostMapping
    public ManutencaoPreventiva criar(@RequestBody ManutencaoPreventiva manutencaoPreventiva) {
        return manutencaoPreventivaRepository.save(manutencaoPreventiva);
    }

    @GetMapping
    public List<ManutencaoPreventiva> listar() {
        return manutencaoPreventivaRepository.findAll();
    }

}
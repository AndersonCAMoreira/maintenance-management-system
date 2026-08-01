package com.anderson.backend.controller;

import com.anderson.backend.entity.OrdemServico;
import com.anderson.backend.repository.OrdemServicoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    private final OrdemServicoRepository ordemServicoRepository;

    public OrdemServicoController(OrdemServicoRepository ordemServicoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
    }

    @PostMapping
    public OrdemServico criar(@RequestBody OrdemServico ordemServico) {
        return ordemServicoRepository.save(ordemServico);
    }

    @GetMapping
    public List<OrdemServico> listar() {
        return ordemServicoRepository.findAll();
    }

}
package com.anderson.backend.controller;

import com.anderson.backend.dto.OrdemServicoDTO;
import com.anderson.backend.service.OrdemServicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    private final OrdemServicoService ordemServicoService;

    public OrdemServicoController(OrdemServicoService ordemServicoService) {
        this.ordemServicoService = ordemServicoService;
    }

    @PostMapping
    public OrdemServicoDTO criar(@RequestBody OrdemServicoDTO dto) {
        return ordemServicoService.criar(dto);
    }

    @GetMapping
    public List<OrdemServicoDTO> listar() {
        return ordemServicoService.listar();
    }

}
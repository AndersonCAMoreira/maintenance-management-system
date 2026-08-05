package com.anderson.backend.controller;

import com.anderson.backend.dto.AtivoDTO;
import com.anderson.backend.service.AtivoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ativos")
public class AtivoController {

    private final AtivoService ativoService;

    public AtivoController(AtivoService ativoService) {
        this.ativoService = ativoService;
    }

    @PostMapping
    public AtivoDTO criar(@RequestBody AtivoDTO ativoDTO) {
        return ativoService.criar(ativoDTO);
    }

    @GetMapping
    public List<AtivoDTO> listar() {
        return ativoService.listar();
    }

    @GetMapping("/operantes")
    public List<AtivoDTO> listarOperantes() {
        return ativoService.listarOperantes();
    }

}
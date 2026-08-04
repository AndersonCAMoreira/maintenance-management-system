package com.anderson.backend.controller;

import com.anderson.backend.dto.SetorDTO;
import com.anderson.backend.service.SetorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setores")
public class SetorController {

    private final SetorService setorService;

    public SetorController(SetorService setorService) {
        this.setorService = setorService;
    }

    @PostMapping
    public SetorDTO criar(@RequestBody SetorDTO setorDTO) {
        return setorService.criar(setorDTO);
    }

    @GetMapping
    public List<SetorDTO> listar() {
        return setorService.listar();
    }

}
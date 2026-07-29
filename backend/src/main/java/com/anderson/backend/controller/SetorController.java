package com.anderson.backend.controller;

import com.anderson.backend.entity.Setor;
import com.anderson.backend.repository.SetorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setores")
public class SetorController {
    private final SetorRepository setorRepository;

    public SetorController(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }


    @PostMapping
    public Setor criar(@RequestBody Setor setor) {
        return setorRepository.save(setor);
    }

    @GetMapping
    public List<Setor> listar() {
        return setorRepository.findAll();
    }
}

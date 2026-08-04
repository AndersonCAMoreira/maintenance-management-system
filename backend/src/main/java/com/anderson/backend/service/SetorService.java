package com.anderson.backend.service;

import com.anderson.backend.dto.SetorDTO;
import com.anderson.backend.entity.Setor;
import com.anderson.backend.repository.SetorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorService {

    private final SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    public SetorDTO criar(SetorDTO setorDTO) {
        Setor setor = new Setor();
        setor.setNome(setorDTO.getNome());
        setor.setTag(setorDTO.getTag());

        Setor salvo = setorRepository.save(setor);

        return new SetorDTO(salvo.getId(), salvo.getNome(), salvo.getTag());
    }

    public List<SetorDTO> listar() {
        return setorRepository.findAll()
            .stream()
            .map(setor -> new SetorDTO(setor.getId(), setor.getNome(), setor.getTag()))
            .toList();
    }

}
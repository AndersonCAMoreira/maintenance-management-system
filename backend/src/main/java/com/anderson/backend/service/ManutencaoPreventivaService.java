package com.anderson.backend.service;

import com.anderson.backend.dto.ManutencaoPreventivaDTO;
import com.anderson.backend.entity.Ativo;
import com.anderson.backend.entity.ManutencaoPreventiva;
import com.anderson.backend.repository.AtivoRepository;
import com.anderson.backend.repository.ManutencaoPreventivaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManutencaoPreventivaService {

    private final ManutencaoPreventivaRepository manutencaoPreventivaRepository;
    private final AtivoRepository ativoRepository;

    public ManutencaoPreventivaService(ManutencaoPreventivaRepository manutencaoPreventivaRepository, AtivoRepository ativoRepository) {
        this.manutencaoPreventivaRepository = manutencaoPreventivaRepository;
        this.ativoRepository = ativoRepository;
    }

    public ManutencaoPreventivaDTO criar(ManutencaoPreventivaDTO dto) {
        ManutencaoPreventiva manutencaoPreventiva = new ManutencaoPreventiva();
        manutencaoPreventiva.setNome(dto.getNome());
        manutencaoPreventiva.setObservacoes(dto.getObservacoes());
        manutencaoPreventiva.setPeriodicidadeDias(dto.getPeriodicidadeDias());
        manutencaoPreventiva.setDataUltimaExecucao(dto.getDataUltimaExecucao());

        if (dto.getDataUltimaExecucao() != null) {
            manutencaoPreventiva.setDataProximaExecucao(
                dto.getDataUltimaExecucao().plusDays(dto.getPeriodicidadeDias())
            );
        }

        Ativo ativo = ativoRepository.findById(dto.getAtivoId())
            .orElseThrow(() -> new RuntimeException("Ativo não encontrado"));
        manutencaoPreventiva.setAtivo(ativo);

        ManutencaoPreventiva salvo = manutencaoPreventivaRepository.save(manutencaoPreventiva);
        return paraDTO(salvo);
    }

    public List<ManutencaoPreventivaDTO> listar() {
        return manutencaoPreventivaRepository.findAll().stream().map(this::paraDTO).toList();
    }

    private ManutencaoPreventivaDTO paraDTO(ManutencaoPreventiva m) {
        ManutencaoPreventivaDTO dto = new ManutencaoPreventivaDTO();
        dto.setId(m.getId());
        dto.setNome(m.getNome());
        dto.setObservacoes(m.getObservacoes());
        dto.setPeriodicidadeDias(m.getPeriodicidadeDias());
        dto.setDataUltimaExecucao(m.getDataUltimaExecucao());
        dto.setDataProximaExecucao(m.getDataProximaExecucao());
        dto.setAtivoId(m.getAtivo().getId());
        return dto;
    }

}
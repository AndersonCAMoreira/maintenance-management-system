package com.anderson.backend.service;

import com.anderson.backend.dto.OrdemServicoDTO;
import com.anderson.backend.entity.Ativo;
import com.anderson.backend.entity.OrdemServico;
import com.anderson.backend.repository.AtivoRepository;
import com.anderson.backend.repository.OrdemServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;
    private final AtivoRepository ativoRepository;

    public OrdemServicoService(OrdemServicoRepository ordemServicoRepository, AtivoRepository ativoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
        this.ativoRepository = ativoRepository;
    }

    public OrdemServicoDTO criar(OrdemServicoDTO dto) {
        OrdemServico os = new OrdemServico();
        os.setStatus(dto.getStatus());
        os.setNomeSolicitante(dto.getNomeSolicitante());
        os.setObservacoes(dto.getObservacoes());
        os.setDataAbertura(dto.getDataAbertura());
        os.setDataConclusao(dto.getDataConclusao());

        Ativo ativo = ativoRepository.findById(dto.getAtivoId())
            .orElseThrow(() -> new RuntimeException("Ativo não encontrado"));
        os.setAtivo(ativo);

        OrdemServico salvo = ordemServicoRepository.save(os);
        return paraDTO(salvo);
    }

    public List<OrdemServicoDTO> listar() {
        return ordemServicoRepository.findAll().stream().map(this::paraDTO).toList();
    }

    private OrdemServicoDTO paraDTO(OrdemServico os) {
        OrdemServicoDTO dto = new OrdemServicoDTO();
        dto.setId(os.getId());
        dto.setStatus(os.getStatus());
        dto.setNomeSolicitante(os.getNomeSolicitante());
        dto.setObservacoes(os.getObservacoes());
        dto.setDataAbertura(os.getDataAbertura());
        dto.setDataConclusao(os.getDataConclusao());
        dto.setAtivoId(os.getAtivo().getId());
        return dto;
    }

}
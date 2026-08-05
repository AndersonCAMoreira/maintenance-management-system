package com.anderson.backend.service;

import com.anderson.backend.dto.AtivoDTO;
import com.anderson.backend.dto.ManutencaoPreventivaDTO;
import com.anderson.backend.dto.OrdemServicoDTO;
import com.anderson.backend.dto.SetorDTO;
import com.anderson.backend.entity.Ativo;
import com.anderson.backend.entity.ManutencaoPreventiva;
import com.anderson.backend.entity.OrdemServico;
import com.anderson.backend.entity.Setor;
import com.anderson.backend.repository.AtivoRepository;
import com.anderson.backend.repository.SetorRepository;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class AtivoService {

    private final AtivoRepository ativoRepository;
    private final SetorRepository setorRepository;

    public AtivoService(AtivoRepository ativoRepository, SetorRepository setorRepository) {
        this.ativoRepository = ativoRepository;
        this.setorRepository = setorRepository;
    }

    public AtivoDTO criar(AtivoDTO dto) {
        Ativo ativo = new Ativo();
        ativo.setNome(dto.getNome());
        ativo.setTipo(dto.getTipo());
        ativo.setStatus(dto.getStatus());
        ativo.setDataCadastro(dto.getDataCadastro());
        ativo.setNumero(dto.getNumero());

        Setor setor = setorRepository.findById(dto.getSetor().getId())
            .orElseThrow(() -> new RuntimeException("Setor não encontrado"));
        ativo.setSetor(setor);

        Ativo salvo = ativoRepository.save(ativo);
        return paraDTO(salvo);
    }

    public List<AtivoDTO> listar() {
        return ativoRepository.findAll().stream().map(this::paraDTO).toList();
    }

    private AtivoDTO paraDTO(Ativo ativo) {
        AtivoDTO dto = new AtivoDTO();
        dto.setId(ativo.getId());
        dto.setNome(ativo.getNome());
        dto.setTipo(ativo.getTipo());
        dto.setStatus(ativo.getStatus());
        dto.setDataCadastro(ativo.getDataCadastro());
        dto.setNumero(ativo.getNumero());

        SetorDTO setorDTO = new SetorDTO(ativo.getSetor().getId(), ativo.getSetor().getNome(), ativo.getSetor().getTag());
        dto.setSetor(setorDTO);

        List<ManutencaoPreventiva> preventivas = ativo.getManutencoesPreventivas();
        if (preventivas != null) {
            dto.setManutencoesPreventivas(preventivas.stream().map(this::paraDTO).toList());
        } else {
            dto.setManutencoesPreventivas(Collections.emptyList());
        }

        List<OrdemServico> ordens = ativo.getOrdensServico();
        if (ordens != null) {
            dto.setOrdensServico(ordens.stream().map(this::paraDTO).toList());
        } else {
            dto.setOrdensServico(Collections.emptyList());
        }

        return dto;
    }

    private ManutencaoPreventivaDTO paraDTO(ManutencaoPreventiva m) {
        ManutencaoPreventivaDTO dto = new ManutencaoPreventivaDTO();
        dto.setId(m.getId());
        dto.setNome(m.getNome());
        dto.setObservacoes(m.getObservacoes());
        dto.setPeriodicidadeDias(m.getPeriodicidadeDias());
        dto.setDataUltimaExecucao(m.getDataUltimaExecucao());
        dto.setDataProximaExecucao(m.getDataProximaExecucao());
        return dto;
    }

    private OrdemServicoDTO paraDTO(OrdemServico os) {
        OrdemServicoDTO dto = new OrdemServicoDTO();
        dto.setId(os.getId());
        dto.setStatus(os.getStatus());
        dto.setNomeSolicitante(os.getNomeSolicitante());
        dto.setObservacoes(os.getObservacoes());
        dto.setDataAbertura(os.getDataAbertura());
        dto.setDataConclusao(os.getDataConclusao());
        return dto;
    }

    public List<AtivoDTO> listarOperantes() {
        return ativoRepository.findByStatus(com.anderson.backend.entity.StatusAtivo.OPERANTE)
            .stream().map(this::paraDTO).toList();
    }
}
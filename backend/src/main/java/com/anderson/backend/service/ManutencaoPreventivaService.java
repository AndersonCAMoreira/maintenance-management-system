package com.anderson.backend.service;

import com.anderson.backend.entity.ManutencaoPreventiva;
import com.anderson.backend.repository.ManutencaoPreventivaRepository;
import org.springframework.stereotype.Service;

@Service
public class ManutencaoPreventivaService {

    private final ManutencaoPreventivaRepository manutencaoPreventivaRepository;

    public ManutencaoPreventivaService(ManutencaoPreventivaRepository manutencaoPreventivaRepository) {
        this.manutencaoPreventivaRepository = manutencaoPreventivaRepository;
    }

    public ManutencaoPreventiva salvar(ManutencaoPreventiva manutencaoPreventiva) {
        if (manutencaoPreventiva.getDataUltimaExecucao() != null) {
            manutencaoPreventiva.setDataProximaExecucao(
                manutencaoPreventiva.getDataUltimaExecucao().plusDays(manutencaoPreventiva.getPeriodicidadeDias())
            );
        }
        return manutencaoPreventivaRepository.save(manutencaoPreventiva);
    }

}
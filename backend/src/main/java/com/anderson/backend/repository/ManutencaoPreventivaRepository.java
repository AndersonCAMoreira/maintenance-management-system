package com.anderson.backend.repository;

import com.anderson.backend.entity.ManutencaoPreventiva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoPreventivaRepository extends JpaRepository<ManutencaoPreventiva, Long> {
    
}
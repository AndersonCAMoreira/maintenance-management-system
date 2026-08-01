package com.anderson.backend.repository;

import com.anderson.backend.entity.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtivoRepository extends JpaRepository<Ativo, Long>{
    
}

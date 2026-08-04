package com.anderson.backend.repository;

import com.anderson.backend.entity.Ativo;
import com.anderson.backend.entity.StatusAtivo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtivoRepository extends JpaRepository<Ativo, Long>{
    List<Ativo> findByStatus(StatusAtivo status);
}

package com.anderson.backend.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ManutencaoPreventivaDTO {

    private Long id;

    @NotNull(message = "O ativo é obrigatório")
    private Long ativoId;

    @NotBlank(message = "O nome da manutenção preventiva é obrigatório")
    private String nome;

    private String observacoes; // Opcional

    @NotNull(message = "A periodicidade em dias é obrigatória")
    @Positive(message = "A periodicidade deve ser maior que zero")
    private Integer periodicidadeDias;

    private LocalDate dataUltimaExecucao; // Opcional
    private LocalDate dataProximaExecucao; // É calculado

    public ManutencaoPreventivaDTO() {
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getObservacoes() {return observacoes;}
    public void setObservacoes(String observacoes) {this.observacoes = observacoes;}

    public Integer getPeriodicidadeDias() {return periodicidadeDias;}
    public void setPeriodicidadeDias(Integer periodicidadeDias) {this.periodicidadeDias = periodicidadeDias;}

    public LocalDate getDataUltimaExecucao() {return dataUltimaExecucao;}
    public void setDataUltimaExecucao(LocalDate dataUltimaExecucao) {this.dataUltimaExecucao = dataUltimaExecucao;}

    public LocalDate getDataProximaExecucao() {return dataProximaExecucao;}
    public void setDataProximaExecucao(LocalDate dataProximaExecucao) {this.dataProximaExecucao = dataProximaExecucao;}

    public Long getAtivoId() {return ativoId;}
    public void setAtivoId(Long ativoId) {this.ativoId = ativoId;}
}
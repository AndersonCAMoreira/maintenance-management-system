package com.anderson.backend.dto;

import java.time.LocalDate;

public class ManutencaoPreventivaDTO {

    private Long id;
    private Long ativoId;
    private String nome;
    private String observacoes;
    private Integer periodicidadeDias;
    private LocalDate dataUltimaExecucao;
    private LocalDate dataProximaExecucao;

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
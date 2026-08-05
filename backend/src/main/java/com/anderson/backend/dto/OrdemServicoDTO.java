package com.anderson.backend.dto;

import com.anderson.backend.entity.StatusOS;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class OrdemServicoDTO {

    private Long id;

    @NotNull(message = "O status é obrigatório")
    private StatusOS status;

    @NotNull(message = "O ativo é obrigatório")
    private Long ativoId;

    @NotBlank(message = "O nome do solicitante é obrigatório")
    private String nomeSolicitante;
    private String observacoes;

    @NotNull(message = "A data de abertura é obrigatória")
    private LocalDateTime dataAbertura;
    private LocalDateTime dataConclusao;

    public OrdemServicoDTO() {
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public StatusOS getStatus() {return status;}
    public void setStatus(StatusOS status) {this.status = status;}

    public String getNomeSolicitante() {return nomeSolicitante;}
    public void setNomeSolicitante(String nomeSolicitante) {this.nomeSolicitante = nomeSolicitante;}

    public String getObservacoes() {return observacoes;}
    public void setObservacoes(String observacoes) {this.observacoes = observacoes;}

    public LocalDateTime getDataAbertura() {return dataAbertura;}
    public void setDataAbertura(LocalDateTime dataAbertura) {this.dataAbertura = dataAbertura;}

    public LocalDateTime getDataConclusao() {return dataConclusao;}
    public void setDataConclusao(LocalDateTime dataConclusao) {this.dataConclusao = dataConclusao;}

    public Long getAtivoId() {return ativoId;}
    public void setAtivoId(Long ativoId) {this.ativoId = ativoId;}
}
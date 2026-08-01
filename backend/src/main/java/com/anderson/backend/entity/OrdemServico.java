package com.anderson.backend.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDateTime;

@Entity
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusOS status;

    private String nomeSolicitante;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    private LocalDateTime dataAbertura;

    private LocalDateTime dataConclusao;

    @ManyToOne
    @JoinColumn(name = "ativo_id")
    @JsonBackReference // Correção do erro de serialização
    private Ativo ativo;
    
    public OrdemServico() {
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

    public Ativo getAtivo() {return ativo;}
    public void setAtivo(Ativo ativo) {this.ativo = ativo;}

}
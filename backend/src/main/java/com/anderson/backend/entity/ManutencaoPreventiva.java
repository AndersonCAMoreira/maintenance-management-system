package com.anderson.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ManutencaoPreventiva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(columnDefinition = "TEXT") //Especificamente TEXT para permitir maior quantidade de carecteres
    private String observacoes;

    private Integer periodicidadeDias;

    private LocalDate dataUltimaExecucao;

    private LocalDate dataProximaExecucao;

    @ManyToOne
    @JoinColumn(name = "ativo_id")
    @JsonBackReference
    private Ativo ativo;

    public ManutencaoPreventiva (){
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getObservacoes () {return observacoes;}
    public void setObservacoes(String observacoes) {this.observacoes = observacoes;}

    public Integer getPeriodicidadeDias() {return periodicidadeDias;}
    public void setPeriodicidadeDias(Integer periodicidadeDias) {this.periodicidadeDias = periodicidadeDias;}

    public LocalDate getDataUltimaExecucao() {return dataUltimaExecucao;}
    public void setDataUltimaExecucao(LocalDate dataUltimaExecucao) {this.dataUltimaExecucao = dataUltimaExecucao;}

    public LocalDate getDataProximaExecucao() {return dataProximaExecucao;}
    public void setDataProximaExecucao(LocalDate dataProximaExecucao) {this.dataProximaExecucao = dataProximaExecucao;}

    public Ativo getAtivo() {return ativo;}
    public void setAtivo(Ativo ativo) {this.ativo = ativo;}
}

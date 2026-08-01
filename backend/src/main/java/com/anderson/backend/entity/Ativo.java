package com.anderson.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Ativo {
    // aqui é definido todas os dados que pertencem a classe ativo
    // tais como (id, nome, tipo, status, dataCadastro, numero, setor)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoAtivo tipo;

    @Enumerated(EnumType.STRING)
    private StatusAtivo status;

    private LocalDate dataCadastro;

    private String numero;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Setor setor;

    @OneToMany(mappedBy = "ativo")
    @JsonManagedReference
    private List<ManutencaoPreventiva> manutencoesPreventivas;

    @OneToMany(mappedBy = "ativo")
    @JsonManagedReference
    private List<OrdemServico> ordensServico;


    //Construtor permite "montar" um ativo sempre que for chamado.
    public Ativo() {
    }

    //getters e setter para para construir as tabelas com as informações
    
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public TipoAtivo getTipo() {return tipo;}
    public void setTipo(TipoAtivo tipo) {this.tipo = tipo;}

    public StatusAtivo getStatus() {return status;}
    public void setStatus(StatusAtivo status) {this.status = status;}

    public LocalDate getDataCadastro() {return dataCadastro;}
    public void setDataCadastro(LocalDate dataCadastro) {this.dataCadastro = dataCadastro;}

    public String getNumero() {return numero;}
    public void setNumero(String numero) {this.numero = numero;}

    public Setor getSetor() {return setor;}
    public void setSetor(Setor setor) {this.setor = setor;}

    public List<ManutencaoPreventiva> getManutencoesPreventivas() {return manutencoesPreventivas;}
    public void setManutencoesPreventivas(List<ManutencaoPreventiva> manutencoesPreventivas) {this.manutencoesPreventivas = manutencoesPreventivas;}

    public List<OrdemServico> getOrdensServico() {return ordensServico;}
    public void setOrdensServico(List<OrdemServico> ordensServico) {this.ordensServico = ordensServico;}
}

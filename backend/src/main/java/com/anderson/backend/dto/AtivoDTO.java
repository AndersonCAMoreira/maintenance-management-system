package com.anderson.backend.dto;

import com.anderson.backend.entity.TipoAtivo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.anderson.backend.entity.StatusAtivo;
import java.time.LocalDate;
import java.util.List;

public class AtivoDTO {

    private Long id;

    @NotBlank(message = "O nome do ativo é obrigatório")
    private String nome;

    @NotNull(message = "O tipo do ativo é obrigatório")
    private TipoAtivo tipo;

    @NotNull(message = "O status do ativo é obrigatório")
    private StatusAtivo status;

    @NotNull(message = "A data de cadastro é obrigatória")
    private LocalDate dataCadastro;

    private String numero; // Opcional 

    @NotNull(message = "O setor é obrigatório")
    @Valid
    private SetorDTO setor;

    private List<ManutencaoPreventivaDTO> manutencoesPreventivas;
    private List<OrdemServicoDTO> ordensServico;

    public AtivoDTO() {
    }

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

    public SetorDTO getSetor() {return setor;}
    public void setSetor(SetorDTO setor) {this.setor = setor;}

    public List<ManutencaoPreventivaDTO> getManutencoesPreventivas() {return manutencoesPreventivas;}
    public void setManutencoesPreventivas(List<ManutencaoPreventivaDTO> manutencoesPreventivas) {this.manutencoesPreventivas = manutencoesPreventivas;}

    public List<OrdemServicoDTO> getOrdensServico() {return ordensServico;}
    public void setOrdensServico(List<OrdemServicoDTO> ordensServico) {this.ordensServico = ordensServico;}

}
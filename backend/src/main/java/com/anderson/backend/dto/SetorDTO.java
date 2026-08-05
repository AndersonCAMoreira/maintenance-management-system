package com.anderson.backend.dto;

import jakarta.validation.constraints.NotBlank;

public class SetorDTO {

    private Long id;
    
    @NotBlank(message = "O nome do setor é obrigatório")
    private String nome;

    @NotBlank(message = "A tag do setor é obrigatória")
    private String tag;

    public SetorDTO() {
    }

    public SetorDTO(Long id, String nome, String tag) {
        this.id = id;
        this.nome = nome;
        this.tag = tag;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getTag() {return tag;}
    public void setTag(String tag) {this.tag = tag;}

}
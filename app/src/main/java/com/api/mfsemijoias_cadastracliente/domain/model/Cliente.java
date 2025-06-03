package com.api.mfsemijoias_cadastracliente.domain.model;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class Cliente {

    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String senha;
    private String usuario;

    public Cliente(String id, String nome, String email, String telefone, String cpf, String senha, String usuario) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.senha = senha;
        this.usuario = usuario;
    }
}
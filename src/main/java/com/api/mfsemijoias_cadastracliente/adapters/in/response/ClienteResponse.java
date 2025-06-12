package com.api.mfsemijoias_cadastracliente.adapters.in.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponse {

    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String senha;
    private String usuario;


}

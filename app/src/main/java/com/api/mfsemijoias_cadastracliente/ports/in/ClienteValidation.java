package com.api.mfsemijoias_cadastracliente.ports.in;

import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;

public interface ClienteValidation {

    boolean clienteValido(Cliente cliente);


    boolean isExistCpf(Cliente cliente);
}

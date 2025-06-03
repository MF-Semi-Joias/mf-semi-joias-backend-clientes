package com.api.mfsemijoias_cadastracliente.domain.validation;

import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;
import com.api.mfsemijoias_cadastracliente.ports.in.ClienteValidation;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;


@Data
@Getter
@Component
public class ClienteValidationImpli implements ClienteValidation {

    private final IsClienteValido isClienteValido;

    public ClienteValidationImpli(IsClienteValido isClienteValido) {
        this.isClienteValido = isClienteValido;
    }

    @Override
    public boolean clienteValido(Cliente cliente) {

        isClienteValido.isValidName(cliente.getNome());
        isClienteValido.isValidCpf(cliente.getCpf());
        isClienteValido.isValidPhoneNumber(cliente.getTelefone());
        isClienteValido.isValidEmail(cliente.getEmail());
        isClienteValido.isValidPassword(cliente.getSenha());
        isClienteValido.isValidUsername(cliente.getUsuario());

        return true;

    }

    @Override
    public boolean isExistCpf(Cliente cliente) {
        return true;
    }
}
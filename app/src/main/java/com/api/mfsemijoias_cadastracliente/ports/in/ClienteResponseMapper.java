package com.api.mfsemijoias_cadastracliente.ports.in;

import com.api.mfsemijoias_cadastracliente.adapters.in.response.ClienteResponse;
import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteResponseMapper {
    ClienteResponseMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ClienteResponseMapper.class);

    ClienteResponse toResponse(Cliente cliente);

    Cliente toDomain(ClienteResponse clienteResponse);
}

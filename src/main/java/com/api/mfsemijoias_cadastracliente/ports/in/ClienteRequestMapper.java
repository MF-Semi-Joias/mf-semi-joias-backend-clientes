package com.api.mfsemijoias_cadastracliente.ports.in;

import com.api.mfsemijoias_cadastracliente.adapters.in.request.ClienteRequest;
import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClienteRequestMapper {
    ClienteRequestMapper INSTANCE = Mappers.getMapper(ClienteRequestMapper.class);
    ClienteRequest toRequest(Cliente cliente);
    Cliente toDomain(ClienteRequest clienteRequest);

}

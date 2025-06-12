package com.api.mfsemijoias_cadastracliente.ports.in;

import com.api.mfsemijoias_cadastracliente.adapters.out.entity.ClienteEntity;
import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);
    @Mapping(target = "id", source = "cliente.id")
    ClienteEntity toEntity(Cliente cliente);
    @Mapping(target = "id", source = "clienteEntity.id")
    Cliente toDomain(ClienteEntity clienteEntity);
}
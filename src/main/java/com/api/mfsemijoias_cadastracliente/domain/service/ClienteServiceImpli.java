package com.api.mfsemijoias_cadastracliente.domain.service;

import com.api.mfsemijoias_cadastracliente.adapters.out.entity.ClienteEntity;
import com.api.mfsemijoias_cadastracliente.ports.in.ClienteRepository;
import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;
import com.api.mfsemijoias_cadastracliente.ports.in.ClienteMapper;
import com.api.mfsemijoias_cadastracliente.ports.in.ClienteService;
import com.api.mfsemijoias_cadastracliente.ports.in.ClienteValidation;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Data
@Service
public class ClienteServiceImpli implements ClienteService {


    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final ClienteValidation clienteValidation;
    private ClienteEntity clienteEntity;
    private static final Logger logger = LoggerFactory.getLogger(ClienteServiceImpli.class);



    public ClienteServiceImpli(ClienteRepository clienteRepository, ClienteMapper clienteMapper, ClienteValidation clienteValidation) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
        this.clienteValidation = clienteValidation;
    }

    @Override
    public void cadastrarCliente(Cliente cliente) {
        clienteValidation.clienteValido(cliente);
        clienteEntity = clienteMapper.toEntity(cliente);
        clienteRepository.save(clienteEntity);

    }

    @Override
    public void atualizarCliente(UUID id, Cliente cliente) {

    }

    @Override
    public void deletarCliente(UUID id) {

    }

    @Override
    public List<Cliente> listarClientes() {
        List<ClienteEntity> clienteEntities = clienteRepository.findAll();
        return clienteEntities.stream()
                .map(clienteMapper::toDomain)
                .toList();
    }

    @Override
    public Cliente buscarClientePorId(UUID id) {
        return null;
    }

    @Override
    public Cliente buscarClientePorUsuario(String usuario) {
        logger.info("Buscando cliente por usuário: {}", usuario);
        clienteEntity = clienteRepository.findByUser(usuario)
                .orElseThrow(() -> {
                    logger.warn("Cliente não encontrado para o usuário: {}", usuario);
                    return new RuntimeException("Cliente não encontrado");
                });
        logger.info("Cliente encontrado: id={}, usuario={}", clienteEntity.getId(), clienteEntity.getUsuario());
        return clienteMapper.toDomain(clienteEntity);
    }

}




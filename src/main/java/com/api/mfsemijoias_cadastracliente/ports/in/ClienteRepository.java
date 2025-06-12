package com.api.mfsemijoias_cadastracliente.ports.in;

import com.api.mfsemijoias_cadastracliente.adapters.out.entity.ClienteEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository  {

    void save(ClienteEntity clienteEntity);
    Optional<ClienteEntity> findByUser(String usuario);
    void findBySenha(String senha);
    List<ClienteEntity> findAll();
    void findById(UUID id);
    void findByEmail(String email);
    void findByCpf(String cpf);
    void findByNome(String nome);
    void deleteById(UUID id);
    void update(ClienteEntity clienteEntity);

}

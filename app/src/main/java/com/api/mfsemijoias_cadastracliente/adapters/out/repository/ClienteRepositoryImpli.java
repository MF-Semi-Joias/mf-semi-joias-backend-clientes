package com.api.mfsemijoias_cadastracliente.adapters.out.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.api.mfsemijoias_cadastracliente.adapters.out.entity.ClienteEntity;
import com.api.mfsemijoias_cadastracliente.ports.in.ClienteRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ClienteRepositoryImpli implements ClienteRepository {


    private final DynamoDBMapper dynamoDBMapper;

    public ClienteRepositoryImpli(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Override
    public void save(ClienteEntity clienteEntity) {
        dynamoDBMapper.save(clienteEntity);

    }

    @Override
    public Optional<ClienteEntity> findByUser(String usuario) {

        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setUsuario(usuario);
        DynamoDBQueryExpression<ClienteEntity> queryExpression = new DynamoDBQueryExpression<ClienteEntity>()
                .withHashKeyValues(clienteEntity)
                .withConsistentRead(false);
        List<ClienteEntity> cliente = dynamoDBMapper.query(ClienteEntity.class, queryExpression);
        if (cliente.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(cliente.get(0));
    }


    @Override
    public void findBySenha(String senha) {

    }

    @Override
    public List<ClienteEntity> findAll() {
        return dynamoDBMapper.scan(ClienteEntity.class, new DynamoDBScanExpression());
    }



    @Override
    public void findById(UUID id) {

    }

    @Override
    public void findByEmail(String email) {

    }

    @Override
    public void findByCpf(String cpf) {

    }

    @Override
    public void findByNome(String nome) {

    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public void update(ClienteEntity clienteEntity) {

    }
}
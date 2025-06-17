package com.api.mfsemijoias_cadastracliente.infra;

import com.api.mfsemijoias_cadastracliente.adapters.out.entity.ClienteEntity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DynamoDBInitializer {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    @PostConstruct
    public void criarPrimeiroUsuario() {
        String usuario = "admin";
        ClienteEntity existente = dynamoDBMapper.load(ClienteEntity.class, usuario);

        if (existente == null) {
            ClienteEntity primeiroUsuario = new ClienteEntity();
            primeiroUsuario.setId(UUID.randomUUID().toString());
            primeiroUsuario.setNome("João Maria");
            primeiroUsuario.setUsuario(usuario);
            primeiroUsuario.setSenha("admin"); // Defina a senha conforme necessário

            dynamoDBMapper.save(primeiroUsuario);
            System.out.println("Primeiro usuário criado com sucesso.");
        } else {
            System.out.println("Usuário inicial já existe.");
        }
    }
}
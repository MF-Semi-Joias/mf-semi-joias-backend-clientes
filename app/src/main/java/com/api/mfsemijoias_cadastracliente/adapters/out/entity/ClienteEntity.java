package com.api.mfsemijoias_cadastracliente.adapters.out.entity;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
@DynamoDBTable(tableName = "clientes")
public class ClienteEntity {

    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBAttribute(attributeName = "nome")
    private String nome;
    @DynamoDBAttribute(attributeName = "email")
    private String email;
    @DynamoDBAttribute(attributeName = "telefone")
    private String telefone;
    @DynamoDBAttribute(attributeName = "cpf")
    private String cpf;
    @DynamoDBAttribute(attributeName = "senha")
    private String senha;
    @DynamoDBIndexHashKey(globalSecondaryIndexName = "usuario")
    private String usuario;


}






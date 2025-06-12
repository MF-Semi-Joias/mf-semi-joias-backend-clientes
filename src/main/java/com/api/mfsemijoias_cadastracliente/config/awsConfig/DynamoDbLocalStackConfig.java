package com.api.mfsemijoias_cadastracliente.config.awsConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClientBuilder;

import java.net.URI;

@Configuration
@Profile("local")
public class DynamoDbLocalStackConfig {

    @Value("${aws.dynamodb.endpoint}")
    private String dynamoDbEndpoint;

    @Bean
    public DynamoDbClient localDynamoDbClient() {
        DynamoDbClientBuilder builder = DynamoDbClient.builder();
        builder.endpointOverride(URI.create(dynamoDbEndpoint));
        builder.region(Region.SA_EAST_1);
        builder.credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("accesskey", "secretkey")));
        return builder.build();
    }
}
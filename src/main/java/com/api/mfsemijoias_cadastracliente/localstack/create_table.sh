#!/bin/bash

awslocal dynamodb create-table \
    --table-name clientes \
    --attribute-definitions \
        AttributeName=id,AttributeType=N \
    --key-schema \
        AttributeName=id,KeyType=HASH \
    --provisioned-throughput \
        ReadCapacityUnits=5,WriteCapacityUnits=5
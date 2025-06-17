provider "aws" {
  access_key = "test"
  secret_key = "test"
  region     = "sa-east-1"
  endpoints {
    dynamodb = "http://localstack:4566"
  }
  skip_credentials_validation = true
  skip_metadata_api_check     = true
  skip_requesting_account_id  = true
}
resource "aws_dynamodb_table" "clientes" {
  name           = "clientes"
  billing_mode   = "PROVISIONED"
  read_capacity  = 5
  write_capacity = 5
  hash_key       = "id"

  attribute {
    name = "id"
    type = "S"
  }

  attribute {
    name = "usuario"
    type = "S"
  }

  global_secondary_index {
    name               = "usuario"
    hash_key           = "usuario"
    projection_type    = "ALL"
    read_capacity      = 5
    write_capacity     = 5
  }
}
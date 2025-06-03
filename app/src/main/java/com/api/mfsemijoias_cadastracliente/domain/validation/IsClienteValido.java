package com.api.mfsemijoias_cadastracliente.domain.validation;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class IsClienteValido {

    // Padrões de validação

    private static final Pattern EMAIL_PATTERN = Pattern.compile
            ("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile
            ("^\\+\\d{1,3}\\d{10,12}$");
    private static final Pattern CPF_PATTERN = Pattern.compile
            ("^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11})$");
    private static final Pattern NAME_PATTERN = Pattern.compile
            ("^[A-Za-zÀ-ÿ\\s]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile
            ("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    private static final Pattern USERNAME_PATTERN = Pattern.compile
            ("^(?=.*[a-zA-Z])(?=.*\\d)[A-Za-z\\d]{6,}$");

    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
        }
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Email inválido");
        }
        return true;
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Número de telefone não pode ser nulo ou vazio");
        }
        if (!PHONE_PATTERN.matcher(phoneNumber).matches()) {
            throw new IllegalArgumentException("Número de telefone inválido");
        }
        return true;
    }

    public boolean isValidCpf(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
        }
        if (!CPF_PATTERN.matcher(cpf).matches()) {
            throw new IllegalArgumentException("CPF inválido");
        }
        return true;
    }

    public boolean isValidName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        if (!NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        return true;
    }

    public boolean isValidPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Senha não pode ser nula ou vazia");
        }
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new IllegalArgumentException("Senha inválida");
        }
        return true;
    }

    public boolean isValidUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Usuário não pode ser nulo ou vazio");
        }
        if (!USERNAME_PATTERN.matcher(username).matches()) {
            throw new IllegalArgumentException("Usuário inválido");
        }
        return true;
    }

    //TODO: Validar data de nascimento

}

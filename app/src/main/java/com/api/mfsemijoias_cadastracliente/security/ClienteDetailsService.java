package com.api.mfsemijoias_cadastracliente.security;

import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;
import com.api.mfsemijoias_cadastracliente.ports.in.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClienteDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(ClienteDetailsService.class);
    private final ClienteService clienteService;

    public ClienteDetailsService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("Tentando carregar usuário: {}", username);
        Cliente cliente = clienteService.buscarClientePorUsuario(username);
        if (cliente == null) {
            logger.warn("Usuário não encontrado: {}", username);
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        logger.info("Usuário encontrado: {}", cliente.getUsuario());
        return User.builder()
                .username(cliente.getUsuario())
                .password(cliente.getSenha())
                .roles("USER")
                .build();
    }
}
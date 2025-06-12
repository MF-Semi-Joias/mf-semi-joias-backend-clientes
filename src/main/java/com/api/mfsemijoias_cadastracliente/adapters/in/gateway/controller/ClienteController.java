package com.api.mfsemijoias_cadastracliente.adapters.in.gateway.controller;

import com.api.mfsemijoias_cadastracliente.adapters.in.request.ClienteRequest;
import com.api.mfsemijoias_cadastracliente.adapters.in.response.ClienteResponse;
import com.api.mfsemijoias_cadastracliente.ports.in.ClienteRequestMapper;
import com.api.mfsemijoias_cadastracliente.ports.in.ClienteResponseMapper;
import org.springframework.http.ResponseEntity;
import com.api.mfsemijoias_cadastracliente.ports.in.ClienteService;
import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteRequestMapper clienteRequestMapper;
    private final ClienteResponseMapper clienteResponseMapper;


    public ClienteController(ClienteService clienteService, ClienteRequestMapper clienteRequestMapper, ClienteResponseMapper clienteResponseMapper) {
        this.clienteService = clienteService;
        this.clienteRequestMapper = clienteRequestMapper;
        this.clienteResponseMapper = clienteResponseMapper;
    }
    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrarCliente(@RequestBody ClienteRequest clienteRequest) {
        Cliente cliente = clienteRequestMapper.toDomain(clienteRequest);
        clienteService.cadastrarCliente(cliente);
        ClienteResponse clienteResponse = clienteResponseMapper.toResponse(cliente);
        return ResponseEntity.status(201).body(clienteResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable UUID id, @RequestBody Cliente cliente) {
        clienteService.atualizarCliente(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable UUID id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable UUID id) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<ClienteResponse> buscarClientePorUser(@PathVariable String usuario) {
        Cliente cliente = clienteService.buscarClientePorUsuario(usuario);
        ClienteResponse clienteResponse = clienteResponseMapper.toResponse(cliente);
        return ResponseEntity.ok(clienteResponse);
    }
}
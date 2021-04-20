package com.example.apiweb.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiweb.ws.model.Cliente;
import com.example.apiweb.ws.repository.ClienteRepository;

@Service
public class ClienteService {
	//iniciando bd
	@Autowired
	ClienteRepository clienteRepository;
	
	//simulando banco
//	private Map<Integer, Cliente> clientes = new HashMap<>();

	// controla id
//	private Integer proximoId = 1;

	// negócios
	public Cliente cadastrar(Cliente cliente) {
		
		// criar id
//		cliente.setId(proximoId);
//		proximoId++;
//
//		clientes.put(cliente.getId(), cliente);
		
		//
		return clienteRepository.save(cliente);
	}

	public Collection<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	public void excluir(Cliente cliente) {
		clienteRepository.delete(cliente);
	}

	public Cliente buscaPorId(Integer identificacao) {
		return clienteRepository.findById(identificacao).get();
	}

	public Cliente depositar(Cliente cliente) {
		
		Float valorTotal = buscaPorId(cliente.getId()).getSaldoConta() + cliente.getSaldoConta();
		cliente.setSaldoConta(valorTotal);
		return clienteRepository.save(cliente);
	}
	
	public Cliente sacar(Cliente cliente) {
		if( buscaPorId(cliente.getId()).getSaldoConta() > cliente.getSaldoConta() ) {
			Float valorTotal = buscaPorId(cliente.getId()).getSaldoConta() - cliente.getSaldoConta();
			cliente.setSaldoConta(valorTotal);
			return clienteRepository.save(cliente);
		} else {
			return null;
		}
	}
	
}

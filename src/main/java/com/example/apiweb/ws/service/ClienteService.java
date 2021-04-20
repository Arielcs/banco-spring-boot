package com.example.apiweb.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiweb.ws.model.Cliente;
import com.example.apiweb.ws.repository.ClienteRepository;

@Service
public class ClienteService {
	//iniciando bd
	@Autowired
	ClienteRepository clienteRepository;

	// negócios
	
	public Cliente cadastrar(Cliente cliente) {		
		
		//salva cliente criado
		return clienteRepository.save(cliente);
	}
	
	//Busca cliente
	public Cliente buscaPorId(Integer identificacao) {
		return clienteRepository.findById(identificacao).get();
	}

	public Cliente depositar(Cliente cliente) {
		
		//pega valor anterior na conta e soma com a atual
		Float valorTotal = buscaPorId(cliente.getId()).getSaldoConta() + cliente.getSaldoConta();
		cliente.setSaldoConta(valorTotal);
		return clienteRepository.save(cliente);
	}
	
	public Cliente sacar(Cliente cliente) {
		
		//Verifica se o valor a ser sacado está disponível
		if( buscaPorId(cliente.getId()).getSaldoConta() > cliente.getSaldoConta() ) {
			Float valorTotal = buscaPorId(cliente.getId()).getSaldoConta() - cliente.getSaldoConta();
			cliente.setSaldoConta(valorTotal);
			return clienteRepository.save(cliente);
		} else {
			return null;
		}
	}
	
}

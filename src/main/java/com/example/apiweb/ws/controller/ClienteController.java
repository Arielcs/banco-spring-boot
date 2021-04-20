package com.example.apiweb.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiweb.ws.model.Cliente;
import com.example.apiweb.ws.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	// End points... comunicações web
	// RequestMapping falando qual o tipo de request e qual o tipo vai receber e enviar de resposta 
	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		Cliente clienteCadastrado = clienteService.cadastrar(cliente);
		
		
		return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/clientes/sacar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> valorASacar(@RequestBody Cliente cliente) {

		Cliente clienteAlterado = clienteService.sacar(cliente);
		if( clienteAlterado == null ) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}
			return new ResponseEntity<>(clienteAlterado, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/clientes/depositar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> valorADepositar(@RequestBody Cliente cliente) {

		Cliente clienteAlterado = clienteService.depositar(cliente);
		
		if( clienteAlterado == null ) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}
		
			return new ResponseEntity<>(clienteAlterado, HttpStatus.OK);
	}

}

package com.sistema.aposta;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sistema.aposta.controller.ClienteController;
import com.sistema.aposta.entities.Cliente;

import com.sistema.aposta.repositories.ClienteRepository;

	@SpringBootTest
	class ClienteControllerTest {

		@Autowired
		private ClienteRepository clienteRepository;
		
		@Autowired
		private ClienteController clienteController;
		
		@Test
		void listarTest() {
			Integer expected = (int)clienteRepository.count();
			Integer result = clienteController.listar().size();
			assertThat(result).isEqualTo(expected);
		}
		
		@Test
	    void incluirTeste(){
	        Integer expected = (int)clienteRepository.count()+1;
	        System.out.println(expected);

	        Cliente cliente = new Cliente();
	        cliente.setIdCliente(0);
	        cliente.setNome("Joao");
	        cliente.setEmail("joao@hotmail.com");
	               
	  

	        clienteController.incluir(cliente);

	        Integer result = (int)clienteRepository.count();

	        assertThat(result).isEqualTo(expected);
	    }
		
		@Test
		void alterarTest() {
			
			Cliente cliente = clienteController.consultar(3);
			
			cliente.setNome("Joao Paulo");
			cliente.setEmail("joao@hotmail.com.br");	
			clienteController.alterar(cliente);		
			Cliente clienteTest = clienteController.consultar(3);	
			
			assertThat(cliente.getNome()).isEqualTo(clienteTest.getNome());
			
		}
		
		@Test
		void consultaTest() {
			Cliente cliente = new Cliente();
			cliente.setNome("Joao Paulo");
			Cliente clienteTest = clienteController.consultar(3);
			
			assertThat(cliente.getNome()).isEqualTo(clienteTest.getNome());
			
			}
}

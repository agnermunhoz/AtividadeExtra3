package br.com.fiap.app;

import java.util.Date;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;

public class Programa {

	public static void main(String[] args) {

		GenericDao<Cliente> clienteDao = new GenericDao<>(Cliente.class);
		
		Cliente cliente = new Cliente("João da Silva", "joao@blau.com");
		Pedido pedido = new Pedido(cliente, new Date(), "Café", 10.9);
		cliente.getPedidos().add(pedido);
		pedido = new Pedido(cliente, new Date(), "Açucar", 3.1);
		cliente.getPedidos().add(pedido);
		pedido = new Pedido(cliente, new Date(), "Leite", 4.5);
		cliente.getPedidos().add(pedido);
		
		clienteDao.adicionar(cliente);
		
		cliente = null;
		
		cliente = clienteDao.buscar(1);
		
		System.out.println(cliente.toString());
		
		cliente.getPedidos().forEach(p -> System.out.println(p.toString()));
		
	}

}

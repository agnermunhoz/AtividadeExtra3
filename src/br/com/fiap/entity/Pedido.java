package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "IDPEDIDO")
	private int id;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER) 
	@JoinColumn(name="IDCLIENTE")
	private Cliente cliente;
	@Column(name = "DATA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	@Column(name = "DESCRICAO")
	private String descricao;
	@Column(name = "VALOR")
	private double valor;
	public Pedido(Cliente cliente, Date data, String descricao, double valor) {
		super();
		this.cliente = cliente;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}
	public Pedido() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", data=" + data + ", descricao=" + descricao + ", valor=" + valor + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id != other.id)
			return false;
		return true;
	}
			
}

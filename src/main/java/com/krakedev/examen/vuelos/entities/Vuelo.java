package com.krakedev.examen.vuelos.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vuelos")
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "codigo", nullable = false, unique = true, length = 10)
	private String codigo;

	@Column(name = "precio_boleto", nullable = false)
	private BigDecimal precioBoleto;

	@Column(name = "asientos_disponibles", nullable = false)
	private Integer asientosDisponibles;

	@Column(name = "destino", length = 100)
	private String destino;

	public Vuelo() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getPrecioBoleto() {
		return precioBoleto;
	}

	public void setPrecioBoleto(BigDecimal precioBoleto) {
		this.precioBoleto = precioBoleto;
	}

	public Integer getAsientosDisponibles() {
		return asientosDisponibles;
	}

	public void setAsientosDisponibles(Integer asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
}
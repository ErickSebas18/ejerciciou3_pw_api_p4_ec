package com.programacion.web.repository;

import java.util.List;

import com.programacion.web.repository.modelo.Vehiculo;

public interface IVehiculoRepository {

	public List<Vehiculo> buscarTodos();
	public Vehiculo buscar(String placa);
}

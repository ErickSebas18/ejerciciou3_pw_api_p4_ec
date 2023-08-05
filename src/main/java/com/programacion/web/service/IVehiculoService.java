package com.programacion.web.service;

import java.util.List;

import com.programacion.web.service.to.VehiculoTO;

public interface IVehiculoService {

	public VehiculoTO buscarPlaca(String placa);
	public List<VehiculoTO> buscarTodos();
}

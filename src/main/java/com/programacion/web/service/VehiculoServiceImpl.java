package com.programacion.web.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion.web.repository.IVehiculoRepository;
import com.programacion.web.repository.modelo.Vehiculo;
import com.programacion.web.service.to.VehiculoTO;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

	@Autowired
	private IVehiculoRepository vehiculoRepository;
	
	@Override
	public VehiculoTO buscarPlaca(String placa) {
		// TODO Auto-generated method stub
		Vehiculo v = this.vehiculoRepository.buscar(placa);
		return this.convertir(v);
	}

	@Override
	public List<VehiculoTO> buscarTodos() {
		// TODO Auto-generated method stub
		List<Vehiculo> v = this.vehiculoRepository.buscarTodos();
		List<VehiculoTO> listaTO = v.stream().map(e ->  this.convertir(e)).collect(Collectors.toList());
		return listaTO;
	}

	private VehiculoTO convertir(Vehiculo vehiculo) {
		VehiculoTO vehiculoTo = new VehiculoTO();
		vehiculoTo.setAnio(vehiculo.getAnio());
		vehiculoTo.setId(vehiculo.getId());
		vehiculoTo.setMarca(vehiculo.getMarca());
		vehiculoTo.setModelo(vehiculo.getModelo());
		vehiculoTo.setPlaca(vehiculo.getPlaca());
		return vehiculoTo;
	}
}

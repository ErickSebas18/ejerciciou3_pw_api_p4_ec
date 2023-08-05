package com.programacion.web.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.programacion.web.repository.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Vehiculo buscar(String placa) {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("Select v from Vehiculo v where v.placa = :placa", Vehiculo.class);
		myQuery.setParameter("placa", placa);
		return myQuery.getSingleResult();
	}


	@Override
	public List<Vehiculo> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("Select e from Vehiculo e", Vehiculo.class);
		return myQuery.getResultList();
	}

}

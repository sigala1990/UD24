package com.crud.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.h2.dao.IEmpleadoDAO;
import com.crud.h2.dto.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	IEmpleadoDAO iempleado;

	@Override
	public List<Empleado> listarEmpleado() {

		return iempleado.findAll();
	}

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
		return iempleado.save(empleado);
	}

	@Override
	public Empleado empleadoXID(Long id) {

		return iempleado.findById(id).get();
	}

	@Override
	public List<Empleado> listarEmpleadoNombre(String nombre) {

		return iempleado.findByNombre(nombre);
	}

	@Override
	public Empleado actualizarEmpleado(Empleado cliente) {

		return iempleado.save(cliente);
	}

	@Override
	public void eliminarEmpleado(Long id) {
		iempleado.deleteById(id);

	}

}

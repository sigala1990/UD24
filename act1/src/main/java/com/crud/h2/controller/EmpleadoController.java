package com.crud.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.h2.dto.Empleado;
import com.crud.h2.service.EmpleadoServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadoController {

	@Autowired
	EmpleadoServiceImpl empleadoServiceImpl;

	@GetMapping("/empleados")
	public List<Empleado> listarEmpelado() {
		return empleadoServiceImpl.listarEmpleado();
	}

	@GetMapping("/empleados/nombre/{nombre}")
	public List<Empleado> listarEmpeladoNombre(@PathVariable(name = "nombre") String nombre) {
		return empleadoServiceImpl.listarEmpleadoNombre(nombre);
	}

	@PostMapping("/empleados")
	public Empleado salvarEmpleado(@RequestBody Empleado empleado) {

		switch (empleado.getTrabajo().toString()) {
		case "IT":
			empleado.setSalario(3000.0);
			break;
		case "RRHH":
			empleado.setSalario(5000.0);
			break;
		default:
			break;
		}
		return empleadoServiceImpl.guardarEmpleado(empleado);
	}

	@GetMapping("/empleados/{id}")
	public Empleado empleadoXID(@PathVariable(name = "id") Long id) {
		Empleado empleado_xid = new Empleado();
		empleado_xid = empleadoServiceImpl.empleadoXID(id);
		System.out.println("Empleado XID: " + empleado_xid);
		return empleado_xid;
	}

	@PutMapping("/empleado/{id}")
	public void actualizarEmpleado(@PathVariable(name = "id") Long id) {
		empleadoServiceImpl.eliminarEmpleado(id);
	}

}

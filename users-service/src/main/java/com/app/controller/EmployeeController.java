package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.EmployeeDTO;
import com.app.service.EmployeeService;

@RestController
@RequestMapping(value = "api/employee/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "list")
	public ResponseEntity<List<EmployeeDTO>> getListOfEmployees() {
		return new ResponseEntity<List<EmployeeDTO>>(employeeService.getEmployeeWithAllotedDepartmentList(),
				HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Integer id) {
		return new ResponseEntity<EmployeeDTO>(employeeService.getEmployeeWithAllotedDepartmentById(id), HttpStatus.OK);
	}

}

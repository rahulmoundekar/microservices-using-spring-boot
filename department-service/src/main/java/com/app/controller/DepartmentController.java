package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Department;
import com.app.repo.DepartmentRepo;

@RestController
@RequestMapping(value = "/api/department/")
public class DepartmentController {

	@Autowired
	DepartmentRepo departmentRepo;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Integer id) {
	//	int c=10/0;
		return new ResponseEntity<Department>(departmentRepo.findById(id).get(), HttpStatus.OK);
	}

}

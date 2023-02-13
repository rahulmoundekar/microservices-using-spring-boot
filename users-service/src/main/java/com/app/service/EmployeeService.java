package com.app.service;

import java.util.List;

import com.app.dto.EmployeeDTO;

public interface EmployeeService {

	public List<EmployeeDTO> getEmployeeWithAllotedDepartmentList();

	public EmployeeDTO getEmployeeWithAllotedDepartmentById(Integer employeeId);

}

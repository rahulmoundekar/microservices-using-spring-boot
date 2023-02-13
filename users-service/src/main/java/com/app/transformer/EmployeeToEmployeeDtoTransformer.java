package com.app.transformer;

import com.app.dto.DepartmentDTO;
import com.app.dto.EmployeeDTO;
import com.app.entity.Employee;

public class EmployeeToEmployeeDtoTransformer {

	public static EmployeeDTO entityToDto(Employee employee, DepartmentDTO departmentDTO) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(employee.getId());
		employeeDTO.setFname(employee.getFname());
		employeeDTO.setLname(employee.getLname());
		employeeDTO.setMobile(employee.getMobile());
		employeeDTO.setDepartment(departmentDTO);
		return employeeDTO;
	}

}

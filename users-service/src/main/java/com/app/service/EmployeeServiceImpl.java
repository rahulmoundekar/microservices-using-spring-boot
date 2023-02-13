package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.dto.DepartmentDTO;
import com.app.dto.EmployeeDTO;
import com.app.entity.Employee;
import com.app.repo.EmployeeRepo;
import com.app.transformer.EmployeeToEmployeeDtoTransformer;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<EmployeeDTO> getEmployeeWithAllotedDepartmentList() {
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();

		List<Employee> list = employeeRepo.findAll();
		for (Employee employee : list) {
			EmployeeDTO employeeResponse = EmployeeToEmployeeDtoTransformer.entityToDto(employee,
					departmentServiceCalling(employee.getDepartmentId()));
			employeeDTOs.add(employeeResponse);
		}
		return employeeDTOs;
	}

	@Override
	public EmployeeDTO getEmployeeWithAllotedDepartmentById(Integer employeeId) {
		EmployeeDTO employeeResponse = null;
		Optional<Employee> optional = employeeRepo.findById(employeeId);
		if (optional.isPresent()) {
			Employee employee = optional.get();
			employeeResponse = EmployeeToEmployeeDtoTransformer.entityToDto(employee,
					departmentServiceCalling(employee.getDepartmentId()));
		}
		return employeeResponse;
	}

	private DepartmentDTO departmentServiceCalling(int departmentId) {
		return restTemplate.getForObject("http://department-service/api/department/" + departmentId,
				DepartmentDTO.class);
	}

}

package com.app.dto;

import lombok.Data;

@Data
public class EmployeeDTO {

	private int id;
	private String fname;
	private String lname;
	private String mobile;
	private DepartmentDTO department;

}

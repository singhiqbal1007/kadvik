package com.cdac.irp.service;

import java.util.List;

import com.cdac.irp.pojos.Student;

public interface IStudentService {
	
	Student Authenticate(String email, String password);
	List<Student> getAllStudents();

}

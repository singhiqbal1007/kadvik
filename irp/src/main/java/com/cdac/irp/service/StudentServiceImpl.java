package com.cdac.irp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.irp.dao.IStudentDao;
import com.cdac.irp.models.StudentRegisterRequestModel;
import com.cdac.irp.pojos.Student;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao dao;

	@Override
	public Integer Authenticate(String email, String password) {
		return dao.Authenticate(email, password);
	}

	@Override
	public List<Student> getAllStudents() {
		return dao.getAllStudents();
	}

	@Override
	public void RegisterStudent(StudentRegisterRequestModel _student) {
		dao.Registration(_student);

	}

}

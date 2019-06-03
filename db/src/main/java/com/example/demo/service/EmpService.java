package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EmpRepository;
import com.example.demo.model.Emp;

@Service
public class EmpService {
	@Autowired
	private EmpRepository empRepository ;
	
	public  Iterable<Emp> getEmp(){
		return empRepository.findAll() ;
	}

		public Optional<Emp> getById(int empid)
		{
			return empRepository.findById(empid);
		}

		public void insert(Emp e) {
			empRepository.save(e);
		}

		public void deletion(int emp_id) {
			empRepository.deleteById(emp_id);
		}
        public void updatebyid(Emp d) {
        	empRepository.save(d);
        }
	
	}

	
  
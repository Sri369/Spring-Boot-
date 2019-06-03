package com.example.demo.controller;

import java.util.Optional;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Emp;
import com.example.demo.service.EmpService;

@RestController
public class EmpController {
    @Autowired
	private EmpService empservice ;
	
	@GetMapping("/emp")
	public Iterable<Emp> getEmp() {
		return empservice.getEmp();
		
	}
	
	@GetMapping("/getid/{empid}")
	public Optional<Emp> getbyid(@PathVariable int empid)
	{
		return empservice.getById(empid);
	}
	
	@PostMapping("/insertion")
	public void insert(@RequestBody  Emp e)
	{
		empservice.insert(e);
	}
	
	@DeleteMapping("/delete/{emp_id}")
	public void delete(int emp_id)
	{
		empservice.deletion(emp_id);
		
	}
	
	@PostMapping("/update/{emp_id}")
	public void update(Emp emp_id)
	{
		empservice.updatebyid(emp_id);
	}
}

package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Emp;

public interface  EmpRepository extends CrudRepository<Emp, Integer>{

} 
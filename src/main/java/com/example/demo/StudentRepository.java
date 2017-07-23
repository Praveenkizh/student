package com.example.demo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface StudentRepository extends MongoRepository<Student, String> {
	public Student findByName(String name);
	public List<Student> findBySubject(String subject);
}

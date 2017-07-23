package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
	@Autowired
	StudentRepository studentRepository;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Map<String, Object> create(@RequestBody Student student) {

		student = studentRepository.save(student);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Student created successfully");
		dataMap.put("status", "1");
		dataMap.put("students", student);
		return dataMap;
	}
	
	/**
	  * GET /read  --> Read a student by student id from the database.
	  */
	 @RequestMapping("/read")
	 public Map<String, Object> read(@RequestParam String id) {
	  Student student = studentRepository.findOne(id);
	  Map<String, Object> dataMap = new HashMap<String, Object>();
	  dataMap.put("message", "student found successfully");
	  dataMap.put("status", "1");
	  dataMap.put("students", student);
	     return dataMap;
	 }
	 
	 /**
	  * GET /read  --> Read all student from the database.
	  */
	 @RequestMapping("/readall")
	 public Map<String, Object> readAll(){
		 List<Student> students = studentRepository.findAll();
		 Map<String, Object> dataMap = new HashMap<String, Object>();
		 dataMap.put("message", "student found successfully");
		 dataMap.put("totalstudent", students.size());
		 dataMap.put("status", "1");
		 dataMap.put("students", students);
		 return dataMap;
	 }
	 
	 /**
	  * GET /read  --> Read all student from the database.
	  */
	 @RequestMapping("/readByName")
	 public Map<String, Object> findByStudentName(@RequestParam String name){
		 Student student = studentRepository.findByName(name);
		  Map<String, Object> dataMap = new HashMap<String, Object>();
		  dataMap.put("message", "student found successfully");
		  dataMap.put("status", "1");
		  dataMap.put("students", student);
		     return dataMap;
	 }
	 
	 /**
	  * GET /read  --> Read all student from the database.
	  */
	 @RequestMapping("/readBySubject")
	 public Map<String, Object> findStudentsBySubject(@RequestParam String subject){
		 List<Student> students = studentRepository.findBySubject(subject);
		  Map<String, Object> dataMap = new HashMap<String, Object>();
		  dataMap.put("message", "student found successfully");
		  dataMap.put("status", "1");
		  dataMap.put("students", students);
		     return dataMap;
	 }
	 
	 /**
	  * GET /update  --> Update a student record and save it in the database.
	  */
	 @RequestMapping("/update")
	 public Map<String, Object> update(@RequestParam String id, @RequestParam String name, String subject, long marks) {

		 Student student = studentRepository.findOne(id);
		 student.setName(name);
		 student.setSubject(subject);
		 student.setMarks(marks);
		 studentRepository.save(student);
		 Map<String, Object> dataMap = new HashMap<String, Object>();
		 dataMap.put("message", "Student updated successfully");
		 dataMap.put("status", "1");
		 dataMap.put("student", student);
		 return dataMap;
	 }
	 
	 /**
	  * GET /delete  --> Delete a student from the database.
	  */
	 @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	 public Map<String, Object> delete(@RequestParam String studentId) {
		 studentRepository.delete(studentId);
		 Map<String, Object> dataMap = new HashMap<String, Object>();
		 dataMap.put("message", "student deleted successfully");
		 dataMap.put("status", "1");
		 return dataMap;
	 }
}

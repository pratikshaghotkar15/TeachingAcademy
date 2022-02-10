package com.example.backend_TeachingAcademy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_TeachingAcademy.exception.ResourceNotFoundException;
import com.example.backend_TeachingAcademy.model.Student;
import com.example.backend_TeachingAcademy.repository.StudentRepository;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;

	// get all students
		@GetMapping("/student")
		public List<Student> getAllStudent(){
			return studentRepository.findAll();
		}	
		
		// create student rest api
		@PostMapping("/student")
		public Student createStudent(@RequestBody Student student) {
			return studentRepository.save(student);
		}
		
		// get student by id rest api
		@GetMapping("/student/{id}")
		public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
			Student student = studentRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("student not exist with id :" + id));
			return ResponseEntity.ok(student);
		}
		
		// update student rest api
		
		@PutMapping("/student/{id}")
		public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails){
			Student student = studentRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("student not exist with id :" + id));
			student.setStu_Name(studentDetails.getStu_Name());
			student.setCourseName(studentDetails.getCourseName());
			student.setCompanyName(studentDetails.getCompanyName());
			student.setFee(studentDetails.getFee());
			
			Student updatedStudent = studentRepository.save(student);
			return ResponseEntity.ok(updatedStudent);
		}
		// delete student rest api
		@DeleteMapping("/student/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id){
			Student student = studentRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("student not exist with id :" + id));
			
			studentRepository.delete(student);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
		
		
}

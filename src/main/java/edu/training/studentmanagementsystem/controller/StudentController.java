package edu.training.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.training.studentmanagementsystem.entity.Student;
import edu.training.studentmanagementsystem.service.StudentService;
import edu.training.studentmanagementsystem.util.ResponseStructure;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public Student saveStudent(@RequestBody Student student,@RequestParam int adminId) {
		return studentService.saveStudent(student,adminId);
	}
	
	@GetMapping
	public Student getStudentById(@RequestParam int studentId) {
		return studentService.findStudentById(studentId);
	}
	
	@PutMapping
	public Student updateStudentById(@RequestParam int studentId,@RequestBody Student student) {
		return studentService.updateStudentById(studentId, student);
	}
	
	@DeleteMapping
	public Student deleteStudentById(@RequestParam int studentId,@RequestParam int adminId) {
		return studentService.deleteStudent(studentId,adminId);
	}
	
	@GetMapping("/admin")  // /student/admin
    public ResponseEntity<ResponseStructure<List<Student>>> getStudents(@RequestParam int adminId){
		return studentService.getStudents(adminId);
	}
}
 
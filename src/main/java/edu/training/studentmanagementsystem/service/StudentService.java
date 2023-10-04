package edu.training.studentmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.training.studentmanagementsystem.dao.AdminDao;
import edu.training.studentmanagementsystem.dao.StudentDao;
import edu.training.studentmanagementsystem.entity.Admin;
import edu.training.studentmanagementsystem.entity.Student;
import edu.training.studentmanagementsystem.exception.StudentNotFoundException;
import edu.training.studentmanagementsystem.util.ResponseStructure;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private AdminDao adminDao;
	
	public Student saveStudent(Student student,int adminId) {
		//finding the admin present in database
		Admin admin=adminDao.findAdminById(adminId);
		//fetching the existing student list with admin
		List<Student> students = admin.getStudents();
		//assigning the new student to the existing student list
		students.add(student);
		//setting the students list with new student to the admin
		admin.setStudents(students);
		//saving student to the database
		Student student2=studentDao.saveStudent(student);
		//updating the students to the admin in the database
		adminDao.saveAdmin(admin); 
		return student2;
	}
	
	public Student findStudentById(int studentId) {
		return studentDao.findStudentById(studentId);
	}
	
	public Student updateStudentById(int studentId,Student student) {
		return studentDao.updateStudentById(studentId, student);
	}
	
	public Student deleteStudent(int studentId,int adminId) {
		Student student=studentDao.findStudentById(studentId);
		if (student!=null) {
			Admin admin=adminDao.findAdminById(adminId);
			if (admin!=null) {
				List<Student> students = admin.getStudents();//5
				students.remove(student);//4
				admin.setStudents(students);//4
				adminDao.updateAdminById(adminId, admin);//5->4
				studentDao.deleteStudent(student);//delete
				return student;
			}else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Student>>> getStudents(int adminId){
		Admin admin=adminDao.findAdminById(adminId);
		 if (admin!=null) {
			 List<Student> students=studentDao.getStudents(adminId);
				if (students!=null) {
					if (students.isEmpty()) {
						throw new StudentNotFoundException("Failed to find Students!");
					} else {
						ResponseStructure<List<Student>> responseStructure=new ResponseStructure<>();
						responseStructure.setStatusCode(HttpStatus.FOUND.value());
						responseStructure.setMessage("Students found");
						responseStructure.setData(students);
						return new ResponseEntity<ResponseStructure<List<Student>>>(responseStructure,HttpStatus.FOUND);
					}
				} else {
					throw new StudentNotFoundException("Failed to find students!");
				}
		} else {
			throw new StudentNotFoundException("Failed to find students!");
		}
	}
}

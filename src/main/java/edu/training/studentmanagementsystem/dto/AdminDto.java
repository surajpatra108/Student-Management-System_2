package edu.training.studentmanagementsystem.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.training.studentmanagementsystem.entity.Student;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class AdminDto {
	private int adminId;
	private String adminName;
	private String adminEmail;
	
	private List<Student> students;
}

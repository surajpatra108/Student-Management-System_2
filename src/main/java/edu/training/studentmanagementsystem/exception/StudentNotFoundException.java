package edu.training.studentmanagementsystem.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@SuppressWarnings("serial")
public class StudentNotFoundException extends RuntimeException{
	private String message;
}

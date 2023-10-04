package edu.training.studentmanagementsystem.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class AdminNotFoundByIdException extends RuntimeException {
	private String message;
}

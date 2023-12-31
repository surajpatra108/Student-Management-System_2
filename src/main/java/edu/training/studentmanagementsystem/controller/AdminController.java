package edu.training.studentmanagementsystem.controller;

import javax.validation.Valid;

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

import edu.training.studentmanagementsystem.entity.Admin;
import edu.training.studentmanagementsystem.service.AdminService;
import edu.training.studentmanagementsystem.util.ResponseStructure;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@Valid @RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Admin>> findAdminById(@RequestParam int adminId) {
		return adminService.findAdminById(adminId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Admin>> updateAdminById(@RequestParam int adminId,@Valid @RequestBody Admin admin) {
		return adminService.updateAdminById(adminId, admin);
	}
	
	@DeleteMapping
	public ResponseEntity<Admin> deleteAdminById(@RequestParam int adminId) {
		return adminService.deleteAdminById(adminId);
	}
}

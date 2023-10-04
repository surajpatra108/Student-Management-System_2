package edu.training.studentmanagementsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.training.studentmanagementsystem.entity.Admin;
import edu.training.studentmanagementsystem.repository.AdminRepo;

@Repository
public class AdminDao {
	@Autowired
	private AdminRepo adminRepo;
	
	public Admin saveAdmin(Admin admin) {
		return adminRepo.save(admin);
	}
	
	public Admin findAdminById(int adminId) {
		Optional<Admin> optional = adminRepo.findById(adminId);
		if (optional.isEmpty()) {
			return null;
		}else {
			Admin admin=optional.get();
			return admin;
		}
	}
	
	public Admin updateAdminById(int adminId,Admin admin) {
		Optional<Admin> optional = adminRepo.findById(adminId);
		if (optional.isEmpty()) {
			return null;
		} else {
			admin.setAdminId(adminId);
			return adminRepo.save(admin);
		}
	}
	
	public Admin deleteAdminById(int adminId) {
		Optional<Admin> optional = adminRepo.findById(adminId);
		if (optional.isEmpty()) {
			return null;
		} else {
			adminRepo.deleteById(adminId);			
			return optional.get();
		}
	}
}

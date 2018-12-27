package service;

import java.util.ArrayList;

import domain.AdminBean;

public interface AdminService {
 //adminNum, pass, auth

	//CREATE
	public void createAdmin(String name, String pass, String auth);
	//READ
	public ArrayList<AdminBean> list();
	public ArrayList<AdminBean> findByAuth(String auth);
	public AdminBean findById(String adminNum);
	public int countAdmin();
	public boolean existAdmin(String adminNum, String pass);
	//UPDATE
	public void updatePass(String adminNum, String pass, String newPass);
	public void updateAuth(String adminNum, String auth);
	//DELETE
	public void deleteAdmin(String adminNum);
}

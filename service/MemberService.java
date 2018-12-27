package service;

import domain.MemberBean;

public interface MemberService {
	//CRUD에서 CR만.
	//name, ssn, id, pass
	/**
	 * CREATE
	 * */
	public void createMember(String name, String ssn, String id, String pass);
	/**
	 * READ
	 * */
	public MemberBean[] findAllMember();
	
	public MemberBean[] findByName(String name);
	
	public MemberBean findById(String id);
	
	public int countMember();
	
	public boolean existMember(String name, String pass);
	/**
	 * UPDATE
	 * */
	public void updatePass(String id, String pass, String newPass);
	/**
	 * DELETE
	 * */
	public void deleteMember(String id, String pass);
	
}

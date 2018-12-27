package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import domain.AdminBean;

public class AdminServiceImpl implements AdminService{
	private HashMap<String,AdminBean> map;
	private int seq;
	public AdminServiceImpl() {
		map = new HashMap<>();
		seq = 1000;
	}
	
	@Override
	public void createAdmin(String name, String pass, String auth) {
		AdminBean admin = new AdminBean();
		admin.setAdminNum(String.valueOf(seq));
		admin.setAuth("staff"); // staff가 우선은 디폴트
		admin.setName(name);
		admin.setPass(pass);
		map.put(admin.getAdminNum(), admin);
		seq++;
	}

	@Override
	public ArrayList<AdminBean> list() {
		//ArrayList<AdminBean> c = (ArrayList<AdminBean>) map.values();
		return (ArrayList<AdminBean>) map.values();
	}

	@Override
	public ArrayList<AdminBean> findByAuth(String auth) {
		ArrayList<AdminBean> list = new ArrayList<>();
		Set<String> set = map.keySet();
		//for each loop라고 함.
		//Set은 인덱스가 없어서 int i=0 이렇게 못돌림.
		//그래서 아래처럼 for를 돌림.
		for(String key: set){
			if(auth.equals(map.get(key).getAuth())){
				list.add(map.get(key));
			}
		}
		return list;
	}

	@Override
	public AdminBean findById(String adminNum) {
		//map을 쓰면 for를 쓰지 않아도 돼서 바로 끝난다.
		return map.get(adminNum);
	}

	@Override
	public int countAdmin() {
		
		return map.size();
	}

	@Override
	public boolean existAdmin(String adminNum, String pass) {
		boolean exist = false;
		if(map.containsKey(adminNum) &&
			map.get(adminNum).getPass().equals(pass)){
			exist = true;
		}
		return exist;
	}

	@Override
	public void updatePass(String adminNum, String pass, String newPass) {
		if(map.get(adminNum).getPass().equals(pass)){
			map.get(adminNum).setPass(newPass);
		}
	}

	@Override
	public void updateAuth(String adminNum, String auth) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAdmin(String adminNum) {
		map.remove(adminNum);
	}

}

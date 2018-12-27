package service;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import domain.AccountBean;

/**
 * @author Seungah Kim
 * @date 2018. 12. 26.
 * @desc 은행계좌 구현객체
 */
public class AccountServiceImpl implements AccountService {
	private ArrayList<AccountBean> list;
	
	public AccountServiceImpl() {
		list = new ArrayList<>();
	}
	/************************************
	 * CREATE
	 ************************************/
	
	@Override
	public void createAccount(int money) {
		AccountBean accountBean = new AccountBean();
		accountBean.setAccountNum(createAccountNum());
		accountBean.setMoney(money);
		accountBean.setToday(findDate());
		list.add(accountBean);
		
	}
	@Override
	public String createAccountNum() {
		int[] number = new int[8];
		String res = "";
		Random random = new Random();
		for(int i=0; i<number.length; i++){
			if(i==3){
				res += random.nextInt(10)+"-";
			}else{
				res += random.nextInt(10);
			}
		}
		return res;
	}

	/************************************
	 * READ
	 ************************************/
	@Override
	public ArrayList<AccountBean> findAll() {
		
		return list;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean account = new AccountBean();
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getAccountNum().equals(accountNum)){
				account = list.get(i);
			}
		}
		return account;
	}

	@Override
	public int countAccount() {
		
		return list.size();
	}

	/*@Override
	public boolean existAccount(String accountNum) {
		
		return false;
	}*/
	
	@Override
	public String findDate() {
		String day = "";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		day = sdf.format(date);
		return day;
	}
	
	/************************************
	 * UPDATE
	 ************************************/
	@Override
	public void depositMoney(String checkAccount, int money) {
		String res = "";
		for(int i=0; i<list.size(); i++){
			if(checkAccount.equals(list.get(i).getAccountNum())){
				if(money>0){
					int inMoney = list.get(i).getMoney();
					inMoney += money;
					list.get(i).setMoney(inMoney);
					res = "입금성공";
					break;
				}else{
					res = "오류";
				}
			}else{
				res = "오류";
			}
		}
	}

	@Override
	public void whithdrawMoney(String checkAccount, int money) {
		String res = "";
		for(int i=0; i<list.size(); i++){
			if(checkAccount.equals(list.get(i).getAccountNum())){
				if(money>0 && money<=list.get(i).getMoney()){
					  int inMoney = list.get(i).getMoney();
					  inMoney -= money;
					  list.get(i).setMoney(inMoney);
					  res = "입금성공";
					  break;
				}else{
					res = "오류";
				}
			}else{
				res = "오류";
			}
		}
	}
	/************************************
	 * DELETE
	 ************************************/
	@Override
	public void deleteAccountNum(String accountNum) {
		for(int i=0; i<list.size(); i++){
			list.remove(i);
		}
		
	}
}

package service;

import java.util.ArrayList;

import domain.AccountBean;

/**
 * @author Seungah Kim
 * @date 2018. 12. 26.
 * @desc 은행계좌 서비스
 */
public interface AccountService {
	//accountNum, today, money
	/**
	 * CREATE
	 * */
	public void createAccount(int money);
	public String createAccountNum(); //계좌번호 생성
	/**
	 * READ
	 * */
	public ArrayList<AccountBean> findAll();
	public AccountBean findByAccountNum(String accountNum);
	public int countAccount();
	public boolean existAccount(String accountNum);
	public String findDate(); //날짜 반환
	/**
	 * UPDATE
	 * */
	public void depositMoney(String checkAccount, int money);
	public void whithdrawMoney(String checkAccount, int money);
	/**
	 * DELETE
	 * */
	public void deleteAccountNum(String accountNum);
	//----------------------------------------------------------
	
}

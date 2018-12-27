package controller;

import javax.swing.JOptionPane;

import domain.AccountBean;
import domain.MemberBean;
import service.AccountService;
import service.AccountServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;

public class BankController {
	MemberBean member = null;
	MemberService service = new MemberServiceImpl();
	
	AccountBean account = null;
	AccountService as = new AccountServiceImpl();
	
	public void start() {
		while(true){
			switch(JOptionPane.showInputDialog(
					"[메뉴]\n"
					+ "0.종료 \n"
					+ "1.회원가입 \n"
					+ "2.회원정보보기 \n"
					+ "3.비밀번호 변경 \n"
					+ "4.계좌오픈 \n"
					+ "5.입금하기 \n"
					+ "6.출금하기 \n"
					+ "7.계좌조회하기")){
			case "0": JOptionPane.showMessageDialog(null, "종료"); return;
			case "1": 
				service.createMember(JOptionPane.showInputDialog("이름"), 
						JOptionPane.showInputDialog("주민등록번호"),
						JOptionPane.showInputDialog("ID"),
						JOptionPane.showInputDialog("비밀번호"));
				break;
			case "2":
				JOptionPane.showMessageDialog(null, service.findAllMember());
				break;
			case "3":
				service.updatePass(JOptionPane.showInputDialog("ID"), 
						JOptionPane.showInputDialog("비밀번호"), 
						JOptionPane.showInputDialog("새로운 비밀번호"));
				break;
			case "4":
				String inputmoney = JOptionPane.showInputDialog("입금액");
				as.createAccount(Integer.parseInt(inputmoney));
				JOptionPane.showMessageDialog(null, as.findAll());
				break;
			case "5":
				String checkAccount = JOptionPane.showInputDialog("계좌번호");
				inputmoney = JOptionPane.showInputDialog("입금액");
				as.depositMoney(checkAccount, Integer.parseInt(inputmoney));
				JOptionPane.showMessageDialog(null, as.findAll());
				break;
			case "6":
				checkAccount = JOptionPane.showInputDialog("계좌번호");
				String outputmoney = JOptionPane.showInputDialog("출금액");
				as.whithdrawMoney(checkAccount, Integer.parseInt(outputmoney));
				break;
			
			}
		}
	}
}

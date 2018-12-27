package service;
/**
 * @author Seungah Kim
 * @date 2018. 12. 26.
 * @desc 멤버기능구현객체
 */
import domain.MemberBean;
public class MemberServiceImpl implements MemberService {
	MemberBean[] members;
	int count;
	public MemberServiceImpl() {
		members = new MemberBean[10];
		count = 0;
	}
	@Override
	public void createMember(String name, String ssn, String id, String pass) {
		MemberBean member = new MemberBean();
		member.setName(name);
		member.setSsn(ssn);
		member.setId(id);
		member.setPass(pass);
		members[count] = member;
		count++;
	}
	
	@Override
	public MemberBean[] findAllMember() {
		
		return members;
	}

	@Override
	public MemberBean[] findByName(String name) {
		int j =0;
		for(int i=0; i<count; i++){
			if(members[i].getName().equals(name)){
				j++;
			}
		}
		MemberBean name1[] = new MemberBean[j];
		j =0;
		for(int i =0; i<count; i++){
			if(members[i].getName().equals(name)){
				name1[j] = members[i];
				j++;
				if(j==name1.length){
					break;
				}
			}
		}
		return name1;
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		for(int i=0; i<count; i++){
			if(members[i].getId().equals(id)){
				member = members[i];
				break;
			}
		}
		return member;
	}

	@Override
	public int countMember() {

		return count;
	}

	@Override
	public boolean existMember(String id, String pass) {
		boolean ok = false;
		for(int i=0; i<count; i++)
		if(members[i].getId().equals(id) && members[i].getId().equals(pass)){
			ok = true;
		}
		return ok;
	}

	@Override
	public void updatePass(String id, String pass, String newPass) {
		for(int i=0; i<count; i++)
			if(members[i].getId().equals(id) && members[i].getId().equals(pass)){
				members[i].setPass(newPass);
			}else{
				
			}
	}

	@Override
	public void deleteMember(String id, String pass) {
		for(int i=0; i<count; i++){
			if(existMember(id, pass)){
				members[i] = members[count-1];
				members[count-1] = null;
				count--;
				break;
			}
		}
	}
}

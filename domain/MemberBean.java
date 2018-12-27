package domain;

public class MemberBean {
	private String name, ssn, id, pass;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return String.format("이름: %s \n"
				+ "주민등록번호: %s \n"
				+ "ID: %s \n"
				+ "비밀번호: %s ", name, ssn, id, pass);
	}
}

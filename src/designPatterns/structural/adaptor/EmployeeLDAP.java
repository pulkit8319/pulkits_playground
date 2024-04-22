package designPatterns.structural.adaptor;

public class EmployeeLDAP {

	private String oid;
	private String givenName;
	private String surName;
	private String post;

	public EmployeeLDAP(String oid, String givenName, String surName, String post) {
		this.oid = oid;
		this.givenName = givenName;
		this.surName = surName;
		this.post = post;
	}

	public String getOid() {
		return oid;
	}

	public String getGivenName() {
		return givenName;
	}

	public String getSurName() {
		return surName;
	}

	public String getPost() {
		return post;
	}

	@Override
	public String toString() {
		return "Id: " + oid + ", FName: " + givenName + ", LName: " + surName + ", Designation: " + post;
	}

}

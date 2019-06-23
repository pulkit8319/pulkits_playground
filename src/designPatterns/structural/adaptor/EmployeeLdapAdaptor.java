package designPatterns.structural.adaptor;

public class EmployeeLdapAdaptor implements Employee {
	
	private EmployeeLDAP employeeLDAP;
	
	public EmployeeLdapAdaptor(EmployeeLDAP instance) {
		this.employeeLDAP = instance;
	}

	@Override
	public String getID() {
		return employeeLDAP.getOid();
	}

	@Override
	public String getFirstName() {
		return employeeLDAP.getGivenName();
	}

	@Override
	public String getLastName() {
		return employeeLDAP.getSurName();
	}

	@Override
	public String getDesgnation() {
		return employeeLDAP.getPost();
	}
	
	@Override
	public String toString() {
		return employeeLDAP.toString();
	}

}

package designPatterns.structural.adaptor;

public class EmployeeDbAdaptor implements Employee {

	private EmployeeFromDB empFromDb;

	public EmployeeDbAdaptor(EmployeeFromDB instance) {
		this.empFromDb = instance;
	}

	@Override
	public String getID() {
		return empFromDb.getId() + "";
	}

	@Override
	public String getFirstName() {
		return empFromDb.getfName();
	}

	@Override
	public String getLastName() {
		return empFromDb.getlName();
	}

	@Override
	public String getDesgnation() {
		return empFromDb.getJobPost();
	}
	
	@Override
	public String toString() {
		return empFromDb.toString();
	}

}

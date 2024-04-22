package designPatterns.structural.adaptor;

public class EmployeeSimple implements Employee {

	private String id;
	private String firstName;
	private String lastName;
	private String designation;

	public EmployeeSimple(String id, String firstName, String lastName, String designation) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
	}

	@Override
	public String getID() {
		return this.id;
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String getDesgnation() {
		return this.designation;
	}

	@Override
	public String toString() {
		return "Id: " + id + ", FName: " + firstName + ", LName: " + lastName + ", Designation: " + designation;
	}

}

package designPatterns.structural.adaptor;

public class EmployeeFromDB {

	private Integer id;
	private String fName;
	private String lName;
	private String jobPost;

	public EmployeeFromDB(Integer id, String fName, String lName, String jobPost) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.jobPost = jobPost;
	}

	public Integer getId() {
		return id;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getJobPost() {
		return jobPost;
	}
	
	@Override
	public String toString() {
		return "Id: " + id + ", FName: " + fName + ", LName: " + lName + ", Designation: " + jobPost;
	}

}

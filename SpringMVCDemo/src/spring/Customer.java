package spring;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import spring.validation.CourseCode;

public class Customer {
	private String firstName;
	 
	@Min(value=0, message="must be greater than or equal to something")
	@Max(value=10, message="must be lower than 10 or equal")
	private int freePasses;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String lastName;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message= "only 5 characters/digits")
	private String postalCode;
	
	@CourseCode
	private String courseCode;
	
	

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	
}

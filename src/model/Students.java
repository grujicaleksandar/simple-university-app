package model;

import javax.persistence.*;

/**
 *
 * @author bagnes
 */
@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Student.getAll", query = "Select e from Students e") })
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private String studentID;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public Students(String studentID, String firstName, String lastName, String address) {
		super();
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
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

	public Students() {
	}
}

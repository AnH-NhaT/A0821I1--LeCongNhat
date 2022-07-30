package example.entity;

import java.time.LocalDate;

public class Intern extends Candidate {
	private String Majors;
	private int Semester;
	private String University_name;

	/**
	 * @param candidateID
	 * @param fullName
	 * @param birthDay
	 * @param phone
	 * @param email
	 * @param candidate_type
	 * @param canidate_count
	 * @param majors
	 * @param semester
	 * @param university_name
	 */
	public Intern(String candidateID, String fullName, LocalDate birthDay, String phone, String email,
			int candidate_type, String majors, int semester, String university_name) {
		super(candidateID, fullName, birthDay, phone, email, candidate_type);
		Majors = majors;
		Semester = semester;
		University_name = university_name;
	}

	/**
	 * 
	 */
	public Intern() {
		super();
	}

	public String getMajors() {
		return Majors;
	}

	public int getSemester() {
		return Semester;
	}

	public String getUniversity_name() {
		return University_name;
	}

	public void setMajors(String majors) {
		Majors = majors;
	}

	public void setSemester(int semester) {
		Semester = semester;
	}

	public void setUniversity_name(String university_name) {
		University_name = university_name;
	}

	@Override
	public String showMe() {
		return super.showInfo() + ", Majors=" + Majors + ", Semester=" + Semester + ", University_name="
				+ University_name;
	}

}

package example.entity;

import java.time.LocalDate;
public abstract class Candidate {
	private String CandidateID;
	private String FullName;
	private LocalDate BirthDay;
	private String Phone;
	private String Email;
	private int Candidate_type;
	private int Canidate_count;

	/**
	 * @param candidateID
	 * @param fullName
	 * @param birthDay
	 * @param phone
	 * @param email
	 * @param candidate_type
	 * @param canidate_count
	 */

	public Candidate(String candidateID, String fullName, LocalDate birthDay, String phone, String email,
			int candidate_type) {
		CandidateID = candidateID;
		FullName = fullName;
		BirthDay = birthDay;
		Phone = phone;
		Email = email;
		Candidate_type = candidate_type;
	}

	/**
	 * 
	 */
	public Candidate() {
	}

	public String getCandidateID() {
		return CandidateID;
	}

	public String getFullName() {
		return FullName;
	}

	public LocalDate getBirthDay() {
		return BirthDay;
	}

	public String getPhone() {
		return Phone;
	}

	public String getEmail() {
		return Email;
	}

	public int getCandidate_type() {
		return Candidate_type;
	}

	public int getCanidate_count() {
		return Canidate_count;
	}

	public void setCandidateID(String candidateID) {
		CandidateID = candidateID;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public void setBirthDay(LocalDate birthDay) {
		BirthDay = birthDay;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public void setCandidate_type(int candidate_type) {
		Candidate_type = candidate_type;
	}

	public void setCanidate_count(int canidate_count) {
		Canidate_count = canidate_count;
	}

	public abstract String showMe();

	public String showInfo() {
		return "CandidateID=" + CandidateID + ", FullName=" + FullName + ", BirthDay=" + BirthDay + ", Phone=" + Phone
				+ ", Email=" + Email + ", Candidate_type=" + Candidate_type;
	}

}

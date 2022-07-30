package example.entity;

import java.time.LocalDate;

public class Fresher extends Candidate {
	private LocalDate Graduation_date;
	private String Graduation_rank;
	private String Education;

	/**
	 * @param candidateID
	 * @param fullName
	 * @param birthDay
	 * @param phone
	 * @param email
	 * @param candidate_type
	 * @param canidate_count
	 * @param graduation_date
	 * @param graduation_rank
	 * @param education
	 */
	public Fresher(String candidateID, String fullName, LocalDate birthDay, String phone, String email,
			int candidate_type, LocalDate graduation_date, String graduation_rank, String education) {
		super(candidateID, fullName, birthDay, phone, email, candidate_type);
		Graduation_date = graduation_date;
		Graduation_rank = graduation_rank;
		Education = education;
	}

	/**
	 * 
	 */
	public Fresher() {
		super();
	}

	public LocalDate getGraduation_date() {
		return Graduation_date;
	}

	public String getGraduation_rank() {
		return Graduation_rank;
	}

	public String getEducation() {
		return Education;
	}

	public void setGraduation_date(LocalDate graduation_date) {
		Graduation_date = graduation_date;
	}

	public void setGraduation_rank(String graduation_rank) {
		Graduation_rank = graduation_rank;
	}

	public void setEducation(String education) {
		Education = education;
	}

	@Override
	public String showMe() {
		return super.showInfo() + ", Graduation_date=" + Graduation_date + ", Graduation_rank=" + Graduation_rank
				+ ", Education=" + Education;
	}

}

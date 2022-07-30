package example.entity;

import java.time.LocalDate;

public class Experience extends Candidate {
	private int ExpInYear;
	private String ProSkill;

	/**
	 * @param candidateID
	 * @param fullName
	 * @param birthDay
	 * @param phone
	 * @param email
	 * @param candidate_type
	 * @param expInYear
	 * @param proSkill
	 */

	public Experience(String candidateID, String fullName, LocalDate birthDay, String phone, String email,
			int candidate_type, int expInYear, String proSkill) {
		super(candidateID, fullName, birthDay, phone, email, candidate_type);
		ExpInYear = expInYear;
		ProSkill = proSkill;
	}

	/**
	 * 
	 */
	public Experience() {
		super();
	}

	public int getExpInYear() {
		return ExpInYear;
	}

	public String getProSkill() {
		return ProSkill;
	}

	public void setExpInYear(int expInYear) {
		ExpInYear = expInYear;
	}

	public void setProSkill(String proSkill) {
		ProSkill = proSkill;
	}

	@Override
	public String showMe() {
		return super.showInfo() + ", ExpInYear=" + ExpInYear + ", ProSkill=" + ProSkill;
	}

}

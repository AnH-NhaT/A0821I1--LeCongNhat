package example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import example.entity.Experience;
import example.entity.Fresher;
import example.entity.Intern;

public class View {
	static Scanner sc = new Scanner(System.in);
	static Service<Object> service = new Service<>();

	public static void insertExperience() {
		try {
			Experience experience = new Experience();
			System.out.println("CandidateID");
			experience.setCandidateID(sc.nextLine());
			System.out.println("FullName");
			experience.setFullName(sc.nextLine());

			System.out.println("BirthDay (yyyy-MM-dd)");
			String temp = sc.nextLine();
			if (LocalDate.parse(temp).isBefore(LocalDate.parse("1900-01-01"))
					|| LocalDate.parse(temp).isAfter(LocalDate.now())) {
				throw new BirthDayException("Date Was wrong!");
			}
			experience.setBirthDay(LocalDate.parse(temp));

			System.out.println("Phone");
			experience.setPhone(sc.nextLine());

			System.out.println("Email");
			temp = sc.nextLine();
			if (!Pattern.compile("^(.+)@(.+)$").matcher(temp).matches()) {
				throw new EmailException("Email Was wrong!");
			}
			experience.setEmail(temp);

			System.out.println("ExpInYear (int)");
			experience.setExpInYear(Integer.parseInt(sc.nextLine()));
			System.out.println("ProSkill");
			experience.setProSkill(sc.nextLine());

			service.insert(experience);
		} catch (BirthDayException e) {
			System.err.println(e);
		} catch (EmailException e) {
			System.err.println(e);
		} catch (Exception e) {
			System.out.println("The system has encountered an unexpected problem,sincerely sorry !!!");
		}
	}

	public static void insertFresher() {
		try {
			Fresher fresher = new Fresher();
			System.out.println("CandidateID");
			fresher.setCandidateID(sc.nextLine());
			System.out.println("FullName");
			fresher.setFullName(sc.nextLine());

			System.out.println("BirthDay (yyyy-MM-dd)");
			String temp = sc.nextLine();
			if (LocalDate.parse(temp).isBefore(LocalDate.parse("1900-01-01"))
					|| LocalDate.parse(temp).isAfter(LocalDate.now())) {
				throw new BirthDayException("Date Was wrong!");
			}
			fresher.setBirthDay(LocalDate.parse(temp));

			System.out.println("Phone");
			fresher.setPhone(sc.nextLine());

			System.out.println("Email");
			temp = sc.nextLine();
			if (!Pattern.compile("^(.+)@(.+)$").matcher(temp).matches()) {
				throw new EmailException("Email Was wrong!");
			}
			fresher.setEmail(temp);

			System.out.println("Graduation_date (yyyy-MM-dd)");
			fresher.setGraduation_date(LocalDate.parse(sc.nextLine()));
			System.out.println("Graduation_rank");
			fresher.setGraduation_rank(sc.nextLine());
			System.out.println("Education");
			fresher.setEducation(sc.nextLine());

			service.insert(fresher);
		} catch (BirthDayException e) {
			System.err.println(e);
		} catch (EmailException e) {
			System.err.println(e);
		} catch (Exception e) {
			System.out.println("The system has encountered an unexpected problem,sincerely sorry !!!");
		}
	}

	public static void insertIntern() {
		try {
			Intern intern = new Intern();
			System.out.println("CandidateID");
			intern.setCandidateID(sc.nextLine());
			System.out.println("FullName");
			intern.setFullName(sc.nextLine());

			System.out.println("BirthDay (yyyy-MM-dd)");
			String temp = sc.nextLine();
			if (LocalDate.parse(temp).isBefore(LocalDate.parse("1900-01-01"))
					|| LocalDate.parse(temp).isAfter(LocalDate.now())) {
				throw new BirthDayException("Date Was wrong!");
			}
			intern.setBirthDay(LocalDate.parse(temp));

			System.out.println("Phone");
			intern.setPhone(sc.nextLine());

			System.out.println("Email");
			temp = sc.nextLine();
			if (!Pattern.compile("^(.+)@(.+)$").matcher(temp).matches()) {
				throw new EmailException("Email Was wrong!");
			}
			intern.setEmail(temp);

			System.out.println("Majors");
			intern.setMajors(sc.nextLine());
			System.out.println("Semester (1 or 2)");
			intern.setSemester(Integer.parseInt(sc.nextLine()));
			System.out.println("University_name");
			intern.setUniversity_name(sc.nextLine());

			service.insert(intern);
		} catch (BirthDayException e) {
			System.err.println(e);
		} catch (EmailException e) {
			System.err.println(e);
		} catch (Exception e) {
			System.out.println("The system has encountered an unexpected problem,sincerely sorry !!!");
		}
	}

	public static void show() {
		service.getData().forEach((e) -> {
			System.out.println(e.showMe());
		});
	}

	public static void showFullname() {
		List<String> arr = new ArrayList<>();
		service.getData().forEach((e) -> {
			arr.add(e.getFullName());
		});
		System.out.println(arr);
	}

	public static void removeDuplicatedID() {
		service.removeDuplicatedID().forEach((e) -> {
			System.out.println(e.showMe());
		});
	}

	public static void sort() {
		service.sort().forEach((e) -> {
			System.out.println(e.showMe());
		});
	}
}

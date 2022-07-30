package example;

import example.entity.Candidate;
import example.entity.Experience;
import example.entity.Fresher;
import example.entity.Intern;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Service<T> {

	private static final String SELECT_ALL = "SELECT * FROM CANDIDATE";
	private static final String INSERT = "INSERT INTO CANDIDATE VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static int count = 0;

	public void insert(T t) {
		try (PreparedStatement insertStatement = ConnectDB.connection().prepareStatement(INSERT)) {

			Candidate candidate = (Candidate) t;
			insertStatement.setString(1, candidate.getCandidateID());
			insertStatement.setString(2, candidate.getFullName());
			insertStatement.setString(3, candidate.getBirthDay().toString());
			insertStatement.setString(4, candidate.getPhone());
			insertStatement.setString(5, candidate.getEmail());

			if (t instanceof Experience) {
				Experience experience = new Experience();
				experience = (Experience) candidate;
				insertStatement.setString(6, "" + 0);
				insertStatement.setString(7, "" + experience.getExpInYear());
				insertStatement.setString(8, experience.getProSkill());

				insertStatement.setString(9, "");
				insertStatement.setString(10, "");
				insertStatement.setString(11, "");

				insertStatement.setString(12, "");
				insertStatement.setString(13, "");
				insertStatement.setString(14, "");
			} else if (t instanceof Fresher) {
				Fresher fresher = new Fresher();
				fresher = (Fresher) candidate;

				insertStatement.setString(6, "" + 1);
				insertStatement.setString(7, "");
				insertStatement.setString(8, "");

				insertStatement.setString(9, fresher.getGraduation_date().toString());
				insertStatement.setString(10, fresher.getGraduation_rank());
				insertStatement.setString(11, fresher.getEducation());

				insertStatement.setString(12, "");
				insertStatement.setString(13, "");
				insertStatement.setString(14, "");
			} else if (t instanceof Intern) {
				Intern intern = new Intern();
				intern = (Intern) candidate;

				insertStatement.setString(6, "" + 2);
				insertStatement.setString(7, "");
				insertStatement.setString(8, "");

				insertStatement.setString(9, "");
				insertStatement.setString(10, "");
				insertStatement.setString(11, "");

				insertStatement.setString(12, intern.getMajors());
				insertStatement.setString(13, "" + intern.getSemester());
				insertStatement.setString(14, intern.getUniversity_name());
			}

			insertStatement.execute();
			count++;
			candidate.setCanidate_count(count);
			System.out.println("amount of candidate just entered is: " + candidate.getCanidate_count());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Candidate> getData() {
		List<Candidate> list = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(SELECT_ALL);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getString(6).equals("0")) {

					list.add(new Experience(resultSet.getString(1), resultSet.getString(2),
							resultSet.getDate(3).toLocalDate(), resultSet.getString(4), resultSet.getString(5),
							resultSet.getInt(6), resultSet.getInt(7), resultSet.getString(8)));

				} else if (resultSet.getString(6).equals("1")) {

					list.add(new Fresher(resultSet.getString(1), resultSet.getString(2),
							resultSet.getDate(3).toLocalDate(), resultSet.getString(4), resultSet.getString(5),
							resultSet.getInt(6), resultSet.getDate(9).toLocalDate(), resultSet.getString(10),
							resultSet.getString(11)));

				} else if (resultSet.getString(6).equals("2")) {

					list.add(new Intern(resultSet.getString(1), resultSet.getString(2),
							resultSet.getDate(3).toLocalDate(), resultSet.getString(4), resultSet.getString(5),
							resultSet.getInt(6), resultSet.getString(12), resultSet.getInt(13),
							resultSet.getString(14)));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	public List<Candidate> removeDuplicatedID() {
		return getData().stream().filter(distinctByKey(p -> p.getCandidateID())).collect(Collectors.toList());
	}

	public List<Candidate> sort() {
		List<Candidate> sort = getData();
		sort.sort(Comparator.comparing(Candidate::getCandidate_type).thenComparing(Candidate::getBirthDay, Comparator.reverseOrder()));
		return sort;
	}
}

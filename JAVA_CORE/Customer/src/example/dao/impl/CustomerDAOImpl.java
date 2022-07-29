package example.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import example.common.ConnectDB;
import example.common.FileProcessing;
import example.dao.CustomerDAO;
import example.entity.Customer;
import example.entity.Foreigner;
import example.entity.LocalPeople;
import example.entity.OutProvincePeople;
import example.validation.CustomerDuplicateException;
import example.validation.DataNotMatchException;

public class CustomerDAOImpl implements CustomerDAO {

	private static final String TRUNCATE = "TRUNCATE TABLE CUSTOMER";
	private static final String SELECT_ALL = "SELECT * FROM CUSTOMER";
	private static final String INSERT = "INSERT INTO CUSTOMER VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String PATH = "src/example/file/Customer.csv";
	private static final String COMMA = ",";

	private static List<String> data = FileProcessing.readFile(PATH);
	private static String[] split;
	private static int price;
	private static String id;

	@Override
	public void insertFromCSV() {
		List<String> listID = new ArrayList<>();
		try {
			PreparedStatement truncateStatement = ConnectDB.connection().prepareStatement(TRUNCATE);
			truncateStatement.execute();
			PreparedStatement insertStatement = ConnectDB.connection().prepareStatement(INSERT);
			for (String s : data) {
				split = s.split(COMMA, -1);
				listID.add(split[1]);
				try {
					if (Period.between(LocalDate.parse(split[3]), LocalDate.now()).getDays() <= 0) {
						throw new DataNotMatchException("BirthDate must be before current date!!!");
					}
					if (split[5].length() != 12) {
						throw new DataNotMatchException("IdentifyID is invalid!!!");
					}
					if (Collections.frequency(listID, split[1]) > 1) {
						throw new CustomerDuplicateException("Customer " + split[1] + " has duplicate ID");
					}

					insertStatement.setString(1, split[0]);
					insertStatement.setString(2, split[1]);
					insertStatement.setString(3, split[2]);
					insertStatement.setString(4, split[3]);
					insertStatement.setString(5, split[4].equals("Male") ? "1" : "0");
					insertStatement.setString(6, split[5]);
					insertStatement.setString(7, split[6]);
					insertStatement.setString(8, split[7]);
					insertStatement.setString(9, split[8]);
					insertStatement.setString(10, split[9]);
					insertStatement.setString(11, split[10]);
					insertStatement.setString(12, split[11]);
					insertStatement.setString(13, split[12]);
					insertStatement.execute();
				} catch (CustomerDuplicateException e) {
					System.err.println(e);
				} catch (DataNotMatchException e) {
					System.err.println(e);
				}

			}
			System.out.println("Successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Program have an unexpected error occurred !!!");
		}
	}

	@Override
	public List<Customer> getData() {
		List<Customer> customerList = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(SELECT_ALL);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getString(1).equals("3")) {
					customerList.add(new Foreigner(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
							resultSet.getDate(4), resultSet.getBoolean(5), resultSet.getString(6), resultSet.getInt(7),
							resultSet.getDate(8), resultSet.getInt(9), resultSet.getString(10), resultSet.getInt(11)));
				} else if (resultSet.getString(1).equals("1")) {
					customerList.add(new LocalPeople(resultSet.getInt(1), resultSet.getString(2),
							resultSet.getString(3), resultSet.getDate(4), resultSet.getBoolean(5),
							resultSet.getString(6), resultSet.getInt(7), resultSet.getDate(8), resultSet.getInt(9),
							resultSet.getString(12)));
				} else if (resultSet.getString(1).equals("2")) {
					customerList.add(new OutProvincePeople(resultSet.getInt(1), resultSet.getString(2),
							resultSet.getString(3), resultSet.getDate(4), resultSet.getBoolean(5),
							resultSet.getString(6), resultSet.getInt(7), resultSet.getDate(8), resultSet.getInt(9),
							resultSet.getString(13)));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		customerList.sort(Comparator.comparing(Customer::getTravelDate).reversed().thenComparing(Customer::getCusID));
		return customerList;
	}

	public void ShowInformation() {
		getData().forEach(System.out::println);
	}

	private static String getDayOfWeek(Date date) {
		return LocalDate.parse(date.toString()).getDayOfWeek().toString();
	}

	@Override
	public void delete() {
		getData().forEach((e) -> {
			if (Period.between(LocalDate.parse(e.getTravelDate().toString()), LocalDate.now()).getYears() > 5) {
				try {
					PreparedStatement preparedStatement = ConnectDB.connection()
							.prepareStatement("DELETE FROM CUSTOMER WHERE CusID = ?");
					preparedStatement.setString(1, e.getCusID());
					preparedStatement.execute();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		System.out.println("Successfully!");
	}

	@Override
	public void update() {
		getData().forEach((e) -> {
			if (Period.between(LocalDate.parse(e.getBirthDate().toString()), LocalDate.now()).getYears() >= 18) {
				if (e.getType() == 3) {
					price = 630000;
					id = e.getCusID();
				} else if (e.getType() == 1) {
					price = 230000;
					id = e.getCusID();
				} else if (e.getType() == 2) {
					price = 430000;
					id = e.getCusID();
				}
			} else {
				if (e.getType() == 3) {
					price = 630000 * 70 / 100;
					id = e.getCusID();
				} else if (e.getType() == 1) {
					price = 230000 * 70 / 100;
					id = e.getCusID();
				} else if (e.getType() == 2) {
					price = 430000 * 70 / 100;
					id = e.getCusID();
				}
			}
			if (!Arrays.asList("SUNDAY", "SATURDAY").contains(getDayOfWeek(e.getBirthDate())))
				price = price * 80 / 100;
			try {
				PreparedStatement preparedStatement = ConnectDB.connection()
						.prepareStatement("UPDATE CUSTOMER SET TicketPrice = ? WHERE CusID = ?");
				preparedStatement.setInt(1, price);
				preparedStatement.setString(2, id);
				preparedStatement.execute();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		System.out.println("Successfully!");
	}
}

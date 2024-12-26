package crup_op_UsingStaticQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReadData {

	static String url = "jdbc:postgresql://localhost:5432/employee_demo?user=postgres&password=root";

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Read Data From Data Base");

		try {
			Class.forName("org.postgresql.Driver");

			Connection connection = DriverManager.getConnection(url);

			String select = "select * from employee_detail";
			PreparedStatement preparedStatement = connection.prepareStatement(select);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				while (resultSet.next()) {
					int employee_id = resultSet.getInt(1);
					String employee_name = resultSet.getString(2);
					String employee_job = resultSet.getString(3);
					long employee_salary = resultSet.getLong(4);

					System.out.println(
							employee_id + "\t\t" + employee_name + "\t\t" + employee_job + "\t\t" + employee_salary);
				}
			} else {
				System.out.print("Data Not Found in Database table");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

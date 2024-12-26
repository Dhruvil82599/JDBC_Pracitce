package com.github.crup_op;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData {

	static String url = "jdbc:postgresql://localhost:5432/employee_demo?user=postgres&password=root";

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Delete Data Using Id");

		System.out.print("Enter Id Which Data you want to delete :-");
		int emp_id = scanner.nextInt();

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url);

			String select = "select employee_id from employee_detail";
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(select);

			if (resultSet.next()) {
				String delete = "delete from employee_detail where employee_id=" + emp_id;
				statement.execute(delete);
				System.out.println("Data Deleted Successfully...");
			} else {
				System.out.println("Id Not Found");
			}
			statement.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

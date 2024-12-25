package com.github.crup_op;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateData {

	public static void main(String[] args) {

		System.out.println("Update Student Data Using scanner Class");

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Employee id:- ");
		int emp_id = sc.nextInt();

		System.out.print("Enter New Employee Name:- ");
		String emp_name = sc.next();

		System.out.print("Enter New Employee Job:-");
		String emp_job = sc.next();

		System.out.print("Enter New Employee Salary :-");
		double emp_salary = sc.nextDouble();

		String url = "jdbc:postgresql://localhost:5432/employee_demo?user=postgres&password=root";

		try {
			// Step 1:- Load/Register The Driver

			Class.forName("org.postgresql.Driver");

			// Step 2:- Establish The Connection

			Connection connection = DriverManager.getConnection(url);

			// Step 3:- Prepared Statement
			Statement statement = connection.createStatement();

			String Update = "update employee_detail set('" + emp_name + "','" + emp_job + "'," + emp_salary
					+ " where employee_id=" + emp_id + ")";
			// Step 4:- Execute Query
			statement.execute(Update);
			System.out.println("Data updated Successfuly...");

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

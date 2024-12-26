package crup_op_UsingStaticQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateData {

	public static void main(String[] args) {

		System.out.println("Update Student Data");

		Scanner sc = new Scanner(System.in);
		String url = "jdbc:postgresql://localhost:5432/employee_demo?user=postgres&password=root";

		try {
			// Step 1:- Load/Register The Driver

			Class.forName("org.postgresql.Driver");

			// Step 2:- Establish The Connection

			Connection connection = DriverManager.getConnection(url);

			// Step 3:- Prepared Statement

			Statement statement = connection.createStatement();
			String select = "select * from employee_detail";
			PreparedStatement preparedStatement = connection.prepareStatement(select);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				String select_Id = "select employee_id from employee_detail";
				PreparedStatement preparedStatement1 = connection.prepareStatement(select_Id);
				ResultSet resultSet1 = preparedStatement.executeQuery();

				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter Employee Id");
				int emp_id = scanner.nextInt();

				System.out.print("Enter New Employee Name:- ");
				String emp_name = sc.next();

				System.out.print("Enter New Employee Job:-");
				String emp_job = sc.next();

				System.out.print("Enter New Employee Salary :-");
				double emp_salary = sc.nextDouble();

				String Update = "UPDATE employee_detail SET employee_name='" + emp_name + "', employee_job='" + emp_job
						+ "', employee_salary=" + emp_salary + " WHERE employee_id=" + emp_id;

				statement.execute(Update);
				System.out.println("Data updated Successfuly...");
			} else {
				System.out.println("Id not Found");
			}

			// Step 4:- Execute Query

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

package crup_op_UsingStaticQuery;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {


	public static void main(String[] args) {

		System.out.println("Insert Employee Data Into Data Base Using Scanner Class");

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Employee id:- ");
		int emp_id = sc.nextInt();

		System.out.print("Enter Employee Name:- ");
		String emp_name = sc.next();

		System.out.print("Enter Employee Job:-");
		String emp_job = sc.next();

		System.out.print("Enter Employee Salary :-");
		double emp_salary = sc.nextDouble();
		
		String url = "jdbc:postgresql://localhost:5432/employee_demo?user=postgres&password=root";


		try {
			// Step 1:- Load/Register The Driver

			Class.forName("org.postgresql.Driver");

			// Step 2:- Establish The Connection

			Connection connection = DriverManager.getConnection(url);

			// Step 3:- Prepared Statement
			Statement statement = connection.createStatement();

			String Query = "insert into employee_detail values(" + emp_id + ",'" + emp_name + "','" + emp_job + "',"
					+ emp_salary +")";

			// Step 4:- Execute Query
			statement.execute(Query);
			System.out.println("Data Inserted Successfuly...");

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

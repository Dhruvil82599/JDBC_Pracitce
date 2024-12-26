package crup_op_UsingDynamicQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {
	public static void main(String[] args) {
		System.out.println("Insert Data Using Scanner Class");

		String url = "jdbc:postgresql://localhost:5432/employee_demo?user=postgres&password=root";

		try {
			Class.forName("org.postgresql.Driver");

			Connection connection = DriverManager.getConnection(url);

			PreparedStatement preparedStatement = connection.prepareStatement(url);

			Scanner sc = new Scanner(System.in);

			System.out.print("Enter Employee Id:- ");
			int emp_id = sc.nextInt();

			System.out.print("Enter Employee Name:- ");
			String emp_name = sc.next();

			System.out.print("Enter Employee Job:- ");
			String emp_job = sc.next();

			System.out.print("Enter Employee Salary:- ");
			long emp_salary = sc.nextInt();

			String Insert = "insert into employee_detail values(?,?,?,?)";

			preparedStatement.setInt(1, emp_id);
			preparedStatement.setString(2, emp_name);
			preparedStatement.setString(3, emp_job);
			preparedStatement.setLong(4, emp_salary);

			int i = preparedStatement.executeUpdate(Insert);

			if (i > 0) {
				System.out.println("Data Inserted Successfully...");
			} else {
				System.out.println("Data Not Inserted");
			}

			preparedStatement.close();
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

package Employee;

import java.util.Scanner;

import com.google.protobuf.BoolValueOrBuilder;

public class Emp_Driver {
	public static void main(String[] args) {
		
	 Scanner scanner=new Scanner(System.in);
	 EMPLOYEE_MANAGMENT emp =new EMPLOYEE_MANAGMENT();
	 boolean choice=true;
	 while (choice) {
		
	
	System.out.println("PRESS..1..FOR INSERT EMLOPYEE\nPRESS..2..FOR FIND EMPLOYEE BY ID \nPRESS..3..FOR VIEW ALL EMPLOYEE\nPRESS..4..FOR DELETE EMPLOYEE BY ID\nPREE..5..FOR UPDATION..\nPRESS..6..FOR( EXIT )");
	int num=scanner.nextInt();
	switch (num) {
	case 1:
		emp.Emp_Insert();
        break;
	case 2:
		 emp.Employee_find_by_id();
		break;
	case 3:
		emp.Show_All_Employee();
		break;
	case 5:
		emp.Emp_Update();
		break;
	case 4:
		emp.delete_emp();
		break;
		
		
		
	case 6:
		System.out.println("............((((......EXITED........))))...........");
		choice=false;

	
	}
		
	}
	}
}

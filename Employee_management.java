package Employee;

import java.util.List;
import java.util.Scanner;

import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class EMPLOYEE_MANAGMENT {
	Scanner r=new Scanner(System.in);
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction et=manager.getTransaction();
	
	public void delete_emp() {
		//Scanner r=new Scanner(System.in);
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction et=manager.getTransaction();
		System.out.println("ENTER EMPLOYEE ID YOU WANT TO DELETE");
		
		int id =r.nextInt();
		Emp emp=manager.find(Emp.class, id);
		if (emp!=null) {
			System.out.println("EMPLOYEE FOUND IN DATABASE WHOSE ID IS:--"+id);
			System.out.println("ARE YOU SURE TO DELETE THIS EMPLOYEE PRESS..1..");
			int press=r.nextInt();
			if (press==1) {
				et.begin();
				manager.remove(emp);
				et.commit();
				System.out.println("EMPLOYEE SUCCESSFULLY DELETED WHOSE ID:--"+id);
				}
				}
			    }
	//.............................METHOD TO INSERT EMPLOYEE.............
	public void  Emp_Insert() {
		boolean choice=true;
		while(choice) {
		System.out.println("........WELCOME TO EMOLPOYEE DATABASE SYSTEM.....");
		System.out.println("1..FOR ADD EMPLOYEE IN THE MYSQL DATABASE\n2..FOR SKIP..");
		int num= r.nextInt();
		//boolean choice=true;
		
		
		if (num==1) {
			
			System.out.println("ENTER EMPLOYEE NAME");
			String empname=r.next();
			
			
			System.out.println("ENTER  EMPLOYEE SALARY");
			int salary=r.nextInt();
			
			System.out.println("ENTER EMPLOYEE JOIN DATE");
			String emp_joindate = r.next();
			
			System.out.println("ENTER EMPLOYEE PHONE_NUMBER");
			Long emp_phone_numeber = r.nextLong();
			//System.out.println("ENTER EMPLOYEE NAME");
			//String empname=r.next();
			
			
			Emp emp =new Emp();
			emp.setEmp_name(empname);
			emp.setSalary(salary);
			emp.setEmp_joindate(emp_joindate);
			emp.setPhonenumber(emp_phone_numeber);
			
			et.begin();
			manager.persist(emp);
			et.commit();
			System.out.println(".............EMPLOYEE ADDED SUCCESSFULLY...........");
			System.out.println(".....");
			System.out.println("               ");
			}
		else {
			System.out.println(">>,,,,,THANK YOU FOR SKIPS,,,,,<<");
			
			choice=false;
		}
		  
		
	}
	}
	
	public void Employee_find_by_id() {
		System.out.println("FIND DETAILS OF YOU EMPLOYEE BY THIRE ID NUMBER PLEASE ENTER ID OF EMPLOYEE.....");
		
		int id=r.nextInt();
		Emp emp = manager.find(Emp.class, id);
		
		if (emp!=null) {
//			System.out.println("NAME OF EMPLOYEE---->>"+emp.getEmp_name());
//			System.out.println("JOINING DATE OF EMPLOYEE---->>"+emp.getEmp_joindate());
//			System.out.println("SALARY OF EMPLOYEE---->>"+emp.getSalary());
//			System.out.println("EMPOYEE PHONE_NUMBER---->>"+emp.getPhonenumber());
			
			System.out.println(emp.toString());
		
	}
}
	public void Show_All_Employee() {
		Query q=manager.createQuery("select s from Emp s",Emp.class);
	    List<Emp>emp1=	q.getResultList();
		
		//List<Teacher> lt=q .getResultList();
		
		for (Emp emp : emp1)
		{
//			System.out.println("NAME OF EMPLOYEE---->>"+emp.getEmp_name());
//		    System.out.println("JOINING DATE OF EMPLOYEE---->>"+emp.getEmp_joindate());
//		    System.out.println("SALARY OF EMPLOYEE---->>"+emp.getSalary());
//			System.out.println("EMPOYEE PHONE_NUMBER---->>"+emp.getPhonenumber());
			System.out.println("...........................................................");
			System.out.println(emp.toString());
		}
		
		
		
	}
	public void Emp_Update() {
		boolean choice= true;
		while (choice) {
			
		
		
		System.out.println(">>>>...ENTER EMPLOOYE ID YOU WANT TO UPDATE..<<<<");
		int id=r.nextInt();
		Emp emp=manager.find(Emp.class, id);
		if (emp!=null) {
		    System.out.println("PRESS...1...FOR UPDATE SALARY\nPRESS...2..FOR UPDATE PHONE_NUMBER\nPRESS...3..FOR EXIT FROM UPDATE");
			int num=r.nextInt();
			switch (num) {
			case 1:
				System.out.println("ENTER NEW SALARY--");
				int salary=r.nextInt();
				emp.setSalary(salary);
				et.begin();
				manager.merge(emp);
				et.commit();
				System.out.println("UPDATE SALARY EMPLOYEE WHOSE ID="+id);
				break;
			case 2:
				System.out.println("ENTER NEW PHONe_NUMBER");
				long phone_number=r.nextLong();
				emp.setPhonenumber(phone_number);
				et.begin();
				manager.merge(emp);
				et.commit();
				System.out.println("UPDATE PHONE_NUMBER EMPLOYEE WHOSE ID="+id);
				
			case 3:
				choice=false;
				System.out.println("\\\\\\\\\\\\\\YOU HAVE SUCCEFULLY EXITED///////////");

			
			}
			
			
			
		}
		
	}
}}


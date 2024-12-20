package quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class quizapp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		participant p=new participant();
		System.out.println("WELCOME TO QUIZ");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name:");
		p.SetName(sc.next());
		System.out.println("Enter the age:");
	    p.SetAge(sc.nextInt());
		System.out.println("Enter the Email ID:");
		p.SetEmail(sc.next());
		System.out.println("Enter the Phone Number:");
	    p.SetPno(sc.nextLong());
		System.out.println("Enter the address:");
		p.SetAddress(sc.next());
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getEmail());
		System.out.println(p.getPno());
		System.out.println(p.getAddress());
		System.out.println("Are you ready to take the quiz game? yes/no");
		String ready=sc.next();
		if(ready.equals("NO")) {
			System.exit(0);
		
		}
		p.displayrules();
		p.playgame();
		}
		catch(ArithmeticException e1) {
			e1.printStackTrace();
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
		}
		catch(Exception e2) {
			e2.printStackTrace();
		}
		
		

}
}

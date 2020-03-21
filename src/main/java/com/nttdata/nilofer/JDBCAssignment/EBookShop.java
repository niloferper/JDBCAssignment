package com.nttdata.nilofer.JDBCAssignment;

import java.util.Scanner;

public class EBookShop {

	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		boolean exitflag = false;
		do {

			System.out.println("------------------------------");
			System.out.println("* 1. Add Book                *");
			System.out.println("* 2. Update Book             *");
			System.out.println("* 3. Delete Book             *");
			System.out.println("* 4. List Books              *");
			System.out.println("* 5. Find Book               *");
			System.out.println("* 0. Exit                    *");
			System.out.println("-----------------------------*");
			System.out.println("Please enter a choice :");

			
			int choice = input.nextInt();
			
			//System.out.println(choice);
			if ((choice < 0) || (choice > 5)) {
				System.out.println("Error , Please enter correct choice");
			//	 choice = input.nextInt();
				continue;
			}
			
			switch (choice) {
			case 1: {

				
				System.out.println("Add New book");
				InsertBook insObj = new InsertBook();
				int rows= insObj.bookInsert();
				if(rows > 0)
				{
					System.out.println("Book added ");
				}
				else
				{
					System.out.println("Error adding Book");
				}
				System.out.println("Enter y to continue");
				input.next();
				break;
			}

			case 2: {

				System.out.println("Update Book");
				UpdateBook upObj = new UpdateBook();
				int num = upObj.bookUpdate();
				if (num>0)System.out.println("Book data updated");
				System.out.println("Enter y to continue");
				input.next();
				break;
			}
			case 3: {

				System.out.println("Delete Book ");
				DeleteBook delObj = new DeleteBook();
				 delObj.bookDelete();
				System.out.println("Enter y to continue");
				input.next();
				break;
			}
			case 4: {

				System.out.println("List Books");
				ListBook showObj = new ListBook();
				int count =showObj.showBooks();
				if(count > 0)
				{
					System.out.println(count + " Book found ");
				}
				System.out.println("Enter y to continue");
				input.next();
				break;
			}
			case 5: {

				System.out.println("Find Book");
				FindBook findObj = new FindBook();
	//			int count;
				try {
			//		count = findObj.showBookById();
					findObj.showBookById();
				} catch (BookIdInvalidException e) {
					System.err.print(e);
				}
//				if (count > 0)
//				{
//					System.out.println(count + " Book found ");
//				}
				System.out.println("\nEnter y to continue");
				input.next();
				break;
			}

			default: {

				System.out.println("Thank you");
				exitflag = true;
				break;
			}
			}
		} while (exitflag == false);
		input.close();
	}
}

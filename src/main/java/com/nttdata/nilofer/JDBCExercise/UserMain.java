package com.nttdata.nilofer.JDBCExercise;

public class UserMain {


		public static void main(String[] args) {
			// TODO Auto-generated method stub
			InsertUser ie = new InsertUser();
			int rows = ie.addNewUser();
			
			if(rows > 0)
			{
				System.out.println("User added successfully");
			}
			else
			{
				System.out.println("Error adding User try again");
			}
		}
	}


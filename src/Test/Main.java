package Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import Accounts.Account;
import bank.Bank;


public class Main 
{	
	static Scanner scanner;
	
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		 scanner = new Scanner(System.in);
		 int input;
		 
		 Bank bank = new Bank();
		 
		while(true) 
		{
			System.out.println("\n########################\n");
			System.out.println("1-Create_S_ID_balance(Hesap no, ba�lang�� paras�)");
			System.out.println("2-Create_L_ID_balance(Hesap no, ba�lang�� paras�)");
			System.out.println("3-Create_C_ID_balance(Hesap no, ba�lang�� paras�)");
			System.out.println("4-Increase_ID_cash(Id)");
			System.out.println("5-Decrease_ID_cash(Id)");
			System.out.println("6-Show Accounts Id And Last 5 Transactions ");
			System.out.println("7-Show Accounts information");
			System.out.println("8-Show accounts id\n");

			System.out.print("L�tfen bir i�lem se�iniz..");
			input = scanner.nextInt();
			Main.requestFromUser(input,bank);
		
		}
	}
	
	static void requestFromUser(int input, Bank bank) 
	{
		
		switch(input) 
		{
		
			case 1:
			{
				bank.createAccount(1);
				break;
			}
		
			case 2:
			{
				bank.createAccount(2);
				break;
			}
		
			case 3:
			{
				bank.createAccount(3);
				break;
			}
		
		
			case 4:
			{
					System.out.print("Para yat�rmak istedi�iniz hesap id:?");
					int id=scanner.nextInt();
					
					if(bank.checkAccountId(id)==true) 
					{
						System.out.print("Yat�rmak istedi�iniz para miktar�:?");
						int cash=scanner.nextInt();
						bank.deposit(id, cash);	
					}
					else 
					{
						System.out.println("Yanl�� �d numaras�..");
					}
								
					break;
			}
		
			case 5:
			{
					System.out.print("Para �ekmek istedi�iniz hesap id:?");
					int id=scanner.nextInt();
					
					if(bank.checkAccountId(id)==true) 
					{
						System.out.print("�ekmek istedi�iniz para miktar�:?");
						int cash=scanner.nextInt();
						bank.Withdraw(id, cash);	
					}
					else 
					{
						System.out.println("Yanl�� �d numaras�..");
					}
					break;
			}
		
			
			case 6:
			{
				/*T�m hesaplar�n idsini ve son 5 i�lemi g�sterir*/
				bank.allAccountId_And_LastFiveTransactions();		
				break;
			}
			
			case 7:
			{
				bank.getAccountInfo();
				break;
			}
			
			case 8:
			{
				bank.getAccountsId();
				break; 
			}
			
			default :
			{
				System.out.println("Ge�ersiz istek..");
			}
		}

	}
	

}

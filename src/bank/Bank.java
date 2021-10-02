package bank;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collection;
import java.util.Collections;

import Accounts.Account;
import Accounts.CurrentAccount;
import Accounts.LongTermAccount;
import Accounts.ShortTermAccount;

import java.time.*;
import java.time.format.DateTimeFormatter;

import Accounts.Account;

public class Bank {

    private ArrayList<Account> accounts ;
	private Scanner scanner;
	private Account account;
	private LocalDate date;
	private DateTimeFormatter dateTimeFormatter;
	
	public Bank() 
	{
		accounts = new ArrayList<Account>();
	}
	
	public void getAccountInfo() 
	{
		/* Mevcut hesaplar�n listesini  g�r�nt�ler */
		if(!accounts.isEmpty()) 
		{
			for (Account account : accounts)
			{
				System.out.println("�d: "+account.getId() + " T�r: "+account.getType() + " Bakiye :" + account.getBakiye() + " A��l�� Tarih: "+account.getDate());		
			}
		}
		else
		{
			System.out.println("G�r�nt�lenecek hesap yok..");
		}
	}
	
	public void getAccountsId() 
	{
		for (Account account : accounts) 
		{
			System.out.println(account.getAccountId());
		}
	}
	
	public void getDate() 
	{
		/* Sistemin �u anki tarihini g�r�nt�lemeyi sa�lar */
		date = LocalDate.now();
		dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		System.out.println(date.format(dateTimeFormatter).toString());
	}
	
	public void deposit(int Id, int cash) 
	{
		if(!accounts.isEmpty())
		{
			for (Account account : accounts) 
			{
				if(Id == account.getAccountId()) 
				{
					account.deposit(Id, cash);
					account.transactions.add("Hesaba "+cash+" TL para yat�r�ld�. ("+date.now() +")");
					System.out.println(account.getId() + " nolu hesab�n�za "+cash+" tl yat�r�ld�.Toplam bakiye: "+account.getBakiye());
					//withdraw da i�lemi yap
				}
				else 
				{
					System.out.println("Yanl�� Hesap Numaras� veya bulunmayan hesap" + Id);
				}
			}		
		}
		else
		{
			System.out.println("Olu�turulmu� hesap yok..");
		}
	}

	
	public void Withdraw(int Id, int cash) 
	{
		if(!accounts.isEmpty())
		{
			for (Account account : accounts) 
			{
				if(Id == account.getAccountId()) 
				{//veriyi varm� diye kontrol et n de veriyi buluyor n+1 tekrar false at�yor 
					//d�zell alg yanl�s
					if(cash <= account.getBakiye()) 
					{
						account.withdraw(Id, cash);
						account.transactions.add("Hesaptan "+cash+" TL para �ekildi.  ("+date.now() +")");
						System.out.println(account.getId() + " nolu hesaptan "+cash + " tl �ekildi.Toplam bakiye : "+account.getBakiye());
						
					}
					else
					{
						System.out.println("Yetersiz Bakiye !");
					}
					
				}
				else 
				{
					System.out.println("Yanl�� Hesap Numaras� veya bulunmayan hesap" + Id);
				}
			}
		}
		else 
		{
			System.out.println("Olu�turulmu� hesap yok..");
		}
	}
	
	public void allAccountId_And_LastFiveTransactions() 
	{
		if(!accounts.isEmpty())
		{
			for (Account account : accounts) 
			{	
				System.out.println("Hesap �d: " + account.getId());
				int count=1;
				for (int i=account.transactions.size()-1; i>=0; i--) 
				{
					if(count<=5) 
					{
						System.out.println((i+1) + ".i�lem : "+account.transactions.get(i));
					}
					count++;
				}
			}
		}
		else 
		{	
			System.out.println("G�r�nt�lenecek hesap Yok..");
		}
		
	}
	
	public void createAccount(int input) 
	{
		 scanner = new Scanner(System.in);
		 int id;
		 int balance;
		 
		if(input==1) 
		{	
			System.out.println("SHORT TERM ACCOUNT");
			System.out.println("�d numaras� giriniz ?");
			id=scanner.nextInt();
			System.out.println("Ba�lang�� para miktar� giriniz.(min 1000TL).");
			balance=scanner.nextInt();
			
			if(balance >= 1000) 
			{
				account = new ShortTermAccount(id, balance);
				accounts.add(account);
				account.transactions.add("Hesap olu�turuldu.. ("+date.now() +")");
				System.out.print("Hesap olu�turuldu");
			}
			else 
			{
				System.out.println("K�sa vadeli hesap olu�turmak i�in minimum 1000 TL bakiye olmal�d�r.");
			}
			
		}
		else if(input==2) 
		{
			System.out.println("LONG TERM ACCOUNT");
			System.out.println("�d numaras� giriniz ?");
			id=scanner.nextInt();
			System.out.println("Ba�lang�� para miktar� giriniz.(min 1500TL).");
			balance=scanner.nextInt();
			
			if(balance >= 1500)
			{
				account = new LongTermAccount(id, balance);
				accounts.add(account);
				account.transactions.add("Hesap olu�turuldu..("+date.now() +")");
				System.out.print("Hesap olu�turuldu");

			}
			else 
			{
				System.out.println("Uzun vadeli hesap olu�turmak i�in minimum 1500 TL bakiye olmal�d�r.");
			}

		}
	
		else if(input==3) 
		{
			System.out.println("CURRENT ACCOUNT");
			System.out.println("�d numaras� giriniz ?");
			id=scanner.nextInt();
			account = new CurrentAccount(id);
			accounts.add(account);
			account.transactions.add("Hesap olu�turuldu..("+date.now() +")");
			System.out.print("Hesap olu�turuldu");


		}
	}
	
	public Boolean checkAccountId(int accountId)
	{		
		Boolean bool=false;
		for (Account account : accounts) 
		{
			if(account.getAccountId() == accountId) 
			{
				bool = true; //accounta aramak yerine id bu listenin i�inde varm� diye kontrol etmen gerek
				//yoksa listenin n.eleman�nda veriyi buluyor true yap�yor sonra n+1.elemanda tekrar false at�yor
				//d�zelt
			}
			else 
			{
				bool=false;
			}
		}
		
		return bool;
	}
	
}

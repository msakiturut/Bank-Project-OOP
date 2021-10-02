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
		/* Mevcut hesaplarýn listesini  görüntüler */
		if(!accounts.isEmpty()) 
		{
			for (Account account : accounts)
			{
				System.out.println("Ýd: "+account.getId() + " Tür: "+account.getType() + " Bakiye :" + account.getBakiye() + " Açýlýþ Tarih: "+account.getDate());		
			}
		}
		else
		{
			System.out.println("Görüntülenecek hesap yok..");
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
		/* Sistemin þu anki tarihini görüntülemeyi saðlar */
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
					account.transactions.add("Hesaba "+cash+" TL para yatýrýldý. ("+date.now() +")");
					System.out.println(account.getId() + " nolu hesabýnýza "+cash+" tl yatýrýldý.Toplam bakiye: "+account.getBakiye());
					//withdraw da iþlemi yap
				}
				else 
				{
					System.out.println("Yanlýþ Hesap Numarasý veya bulunmayan hesap" + Id);
				}
			}		
		}
		else
		{
			System.out.println("Oluþturulmuþ hesap yok..");
		}
	}

	
	public void Withdraw(int Id, int cash) 
	{
		if(!accounts.isEmpty())
		{
			for (Account account : accounts) 
			{
				if(Id == account.getAccountId()) 
				{//veriyi varmý diye kontrol et n de veriyi buluyor n+1 tekrar false atýyor 
					//düzell alg yanlýs
					if(cash <= account.getBakiye()) 
					{
						account.withdraw(Id, cash);
						account.transactions.add("Hesaptan "+cash+" TL para çekildi.  ("+date.now() +")");
						System.out.println(account.getId() + " nolu hesaptan "+cash + " tl çekildi.Toplam bakiye : "+account.getBakiye());
						
					}
					else
					{
						System.out.println("Yetersiz Bakiye !");
					}
					
				}
				else 
				{
					System.out.println("Yanlýþ Hesap Numarasý veya bulunmayan hesap" + Id);
				}
			}
		}
		else 
		{
			System.out.println("Oluþturulmuþ hesap yok..");
		}
	}
	
	public void allAccountId_And_LastFiveTransactions() 
	{
		if(!accounts.isEmpty())
		{
			for (Account account : accounts) 
			{	
				System.out.println("Hesap Ýd: " + account.getId());
				int count=1;
				for (int i=account.transactions.size()-1; i>=0; i--) 
				{
					if(count<=5) 
					{
						System.out.println((i+1) + ".iþlem : "+account.transactions.get(i));
					}
					count++;
				}
			}
		}
		else 
		{	
			System.out.println("Görüntülenecek hesap Yok..");
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
			System.out.println("Ýd numarasý giriniz ?");
			id=scanner.nextInt();
			System.out.println("Baþlangýç para miktarý giriniz.(min 1000TL).");
			balance=scanner.nextInt();
			
			if(balance >= 1000) 
			{
				account = new ShortTermAccount(id, balance);
				accounts.add(account);
				account.transactions.add("Hesap oluþturuldu.. ("+date.now() +")");
				System.out.print("Hesap oluþturuldu");
			}
			else 
			{
				System.out.println("Kýsa vadeli hesap oluþturmak için minimum 1000 TL bakiye olmalýdýr.");
			}
			
		}
		else if(input==2) 
		{
			System.out.println("LONG TERM ACCOUNT");
			System.out.println("Ýd numarasý giriniz ?");
			id=scanner.nextInt();
			System.out.println("Baþlangýç para miktarý giriniz.(min 1500TL).");
			balance=scanner.nextInt();
			
			if(balance >= 1500)
			{
				account = new LongTermAccount(id, balance);
				accounts.add(account);
				account.transactions.add("Hesap oluþturuldu..("+date.now() +")");
				System.out.print("Hesap oluþturuldu");

			}
			else 
			{
				System.out.println("Uzun vadeli hesap oluþturmak için minimum 1500 TL bakiye olmalýdýr.");
			}

		}
	
		else if(input==3) 
		{
			System.out.println("CURRENT ACCOUNT");
			System.out.println("Ýd numarasý giriniz ?");
			id=scanner.nextInt();
			account = new CurrentAccount(id);
			accounts.add(account);
			account.transactions.add("Hesap oluþturuldu..("+date.now() +")");
			System.out.print("Hesap oluþturuldu");


		}
	}
	
	public Boolean checkAccountId(int accountId)
	{		
		Boolean bool=false;
		for (Account account : accounts) 
		{
			if(account.getAccountId() == accountId) 
			{
				bool = true; //accounta aramak yerine id bu listenin içinde varmý diye kontrol etmen gerek
				//yoksa listenin n.elemanýnda veriyi buluyor true yapýyor sonra n+1.elemanda tekrar false atýyor
				//düzelt
			}
			else 
			{
				bool=false;
			}
		}
		
		return bool;
	}
	
}

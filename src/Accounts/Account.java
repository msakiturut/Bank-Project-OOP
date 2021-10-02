package Accounts;

import java.util.ArrayList;
import java.time.*;
import java.time.format.DateTimeFormatter;

public abstract class Account 
{
	
	private int account_id;
	private int bakiye=0;
    protected AccountType type;
    public ArrayList<String> transactions;
    protected String openedDate;
    private LocalDate date;
    DateTimeFormatter dateTimeFormatter;
    protected LocalDate opening_account_date;
    
    public Account() 
    {
		// TODO Auto-generated constructor stub
    	transactions = new ArrayList<String>();
    	dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    	openedDate = LocalDate.now().format(dateTimeFormatter);
    	opening_account_date = LocalDate.now();
	}
	
	public void setBakiye(int bakiye) 
	{
		this.bakiye = bakiye;
	}
	
	public int getBakiye() 
	{
		return bakiye;
	}
	
	public void setAccountId(int id) 
	{	
		if(this.account_id == 0) 
		{
			this.account_id=id;
		}
		else 
		{
			System.out.println("Hesap id numarasý deðiþtirilemez..");
		}
	}
	
	public int getAccountId() 
	{
		return this.account_id;
	}
	
	public  void deposit(int accountId, int cash) 
	{
	/* hesaba para yatýrýlmasýný saðlar */	
		
		if(this.account_id==accountId) 
		{
			bakiye +=cash;
		}
	}
	
	public void withdraw(int accountId, int cash) 
	{
		/*Hesaptan para çekilmesi iþlemini saðlar*/		
		
		if(account_id == accountId) 
		{
			bakiye -=cash;
		}
		
	}
	
	public int getBalance() 
	{
	/*hesabýn anlýk bakiyesini görüntülemeye saðlar.*/
		
		return bakiye;
	}
	
	public int getId() 
	{
		/*Hesap numarasýný görüntülemeye saðlar.*/	
		return getAccountId();
	}
	
	public String  getDate() 
	{
		return openedDate;
	}
	
	public AccountType getType()
	{
		return type;
	}
	public abstract float benefit();
	
	public abstract void accountRules();
	
}


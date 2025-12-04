import java.util.*;
import java.time.LocalDateTime;

class Transaction{
	private String type;
	private double amount;
	private LocalDateTime time;
	
	Transaction(String type, double amount){
		this.type = type;
		this.amount = amount;
		this.time = LocalDateTime.now();
	}
	
	void display(){
		System.out.println("Type: "+type+"	Amount:"+amount+"	Time:"+time);
	}
	
}

class BankManagementSystem{
	public static void main(String[] args){
		Transaction t1 = new Transaction("Deposit",2500);
		t1.display();
	}
}
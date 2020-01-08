package fr.epita.bank.datamodel;

public class Account {
	
	protected double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		if (balance < 0 ) {
			return;
		}
		this.balance = balance;
	}

	 
	 
}

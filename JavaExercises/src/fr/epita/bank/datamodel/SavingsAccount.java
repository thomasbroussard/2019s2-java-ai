package fr.epita.bank.datamodel;

public class SavingsAccount extends Account {

	 private double interestRate;
	 
	 
	 public double calculateInterest() {
		 return this.interestRate * this.balance;
		 
	 }
	 

	public void withDraw(double amount) {
		 this.balance -= amount;
	//	 this.balance = this.balance - amount;
		 
	 }
	
	 public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		if (interestRate == 0) {
			return;
		}
		this.interestRate = interestRate;
	}

	 
}

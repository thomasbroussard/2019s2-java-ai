package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.SavingsAccount;

public class Main {
	
	public static void main(String[] args) {
		SavingsAccount account = new SavingsAccount();
		account.setBalance(300);
		account.setInterestRate(0.0075);
		double calculatedInterest = account.calculateInterest();
		System.out.println(calculatedInterest);
		
		
		account.withDraw(100);
		
		double balance = account.getBalance();
		
		
		System.out.println(balance);
	}

}

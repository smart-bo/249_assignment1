package lab249;

public class lab3{
public class BankAccount {
	private int accountnumber;
	private String accountname;
	private double balance;

	public String toString(BankAccount a) {
		return ("Name: " + a.accountname + "\r\nNumber:" + a.accountnumber + "\r\nbalance" + a.balance);
	}}

public class SavingAccount extends BankAccount{
	
}
}
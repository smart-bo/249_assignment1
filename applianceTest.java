package asssignment1;

import java.util.Scanner;

public class applianceTest {
	private static final String passwordRequired = "c249";
	static Scanner keyboard = new Scanner(System.in);
	static int space = 0;
	static int times = 0;
	static int globalAttempts = 0;
	static String password;
	static int option;
	static boolean pass = false;
	static boolean find = false;
	static int item;

	public static void main(String[] args) {

		System.out.println("             Welcome to store management system!\n");
		Appliance[] inventory = createStoreStock();
		displayMainMenu(inventory);
	}

	public static void terminate() {
		System.out.println("Program   detected   suspicious   activities   and   will   terminate   immediately!");
		System.exit(0);
	}

	private static Appliance[] createStoreStock() {
		System.out.println("Pls input the Maximum stock:");
		int space = keyboard.nextInt();
		return new Appliance[space];
	}

	public static void displayMainMenu(Appliance[] inventory) {
		if (globalAttempts < 12) {
			do {
				System.out.println("What do you want to do?\r\n" + "    1.Enter new appliances (password required)\r\n"
						+ "    2.Change information of an appliance (password required)\r\n"
						+ "    3.Display all appliances by a specific brand\r\n"
						+ "    4.Display all appliances under a certain a price.\r\n" + "    5.Quit\r\n"
						+ "Please enter your choice>");

				option = keyboard.nextInt();
			} while (isNotValid(option));
			processUserOption(inventory);
		}
		terminate();
	}

	private static void processUserOption(Appliance[] inventory) {
		switch (option) {
		case 1:
			processOptionOne(inventory);
			break;
		case 2:
			processOptionTwo(inventory);
			checkPassword();
		
		case 3:
			System.out.println("Pls input the brand you want to display ");
			findAppliancesBy(keyboard.nextLine(), inventory);
			break;
		case 4:
			System.out.println("Pls input the value you want to display ");
			findCheaperThan(keyboard.nextDouble(), inventory);
			break;
		case 5:
			System.out.println("Thank you, Bye.");
			System.exit(0);
		}
	}

	public static boolean isNotValid(int option) {
		return !(option > 0 && option < 6);
	}

	public static boolean checkPassword() {
		System.out.println("Pls input your password: ");
		return keyboard.next().equals(passwordRequired);

	}

	private static void processOptionOne(Appliance[] inventory) {
		int ownerAttempts = 0;
		boolean keepChecking = true;

		while (true) {
			if (checkPassword()) {
				createNewAppliances(inventory);
				keepChecking = false;
			} else {
				ownerAttempts++;
				if (ownerAttempts == 3) {
					keepChecking = false;
					globalAttempts = globalAttempts + 3;
					displayMainMenu(inventory);
				}
			}
		}

	}

	private static void processOptionTwo(Appliance[] inventory) {
		int ownerAttempts = 0;
		while(true) {
			if (checkPassword()) {
				while(true){
					changeAppliances(inventory);
				}
				
			} else
			{
				ownerAttempts++;
			   if(ownerAttempts==3)
				displayMainMenu(inventory);
			}
		}
	}

	public static void findAppliancesBySN(long SN, Appliance inventory[]) {

		for (int i = 0; i < space; i++) {
			if (inventory[i].getSN() == SN) {
				find = true;
				item = i;
				System.out.println(inventory[i]);
				break;
			} else {
				continue;
			}
		}
		if (find == false) {
			System.out.println("Can't find this SN!");
			System.out.println(
					"What do you want to do?\r\n" + "    1.Enter new SN \r\n" + "    2.Return to mainmenu \r\n");
			option = keyboard.nextInt();
		}
	}
	
	public static void changeAppliances(Appliance[] inventory) {
		System.out.println("Pls input the SN of appliance you want to change");
		findAppliancesBySN(keyboard.nextLong(), inventory);

		if (option == 1) {
			System.out.println("What information would you like to change?\r\n" + "1. brand\r\n" + "2. type\r\n"
					+ "3. price\r\n" + "4. Quit\r\n" + "Enter your choice >");
			switch(keyboard.nextInt()) {
			case 1: System.out.println("Pls input the new brand");
			    inventory[item].setbrand(keyboard.next());
			    System.out.println(inventory[item]);
		
			case 2: System.out.println("Pls input the new type");
				inventory[item].settype(keyboard.next());
				System.out.println(inventory[item]);
				
			case 3: System.out.println("Pls input the new price");
				inventory[item].setprice(keyboard.nextDouble());
				System.out.println(inventory[item]);
				
			case 4:displayMainMenu(inventory);
			default: break;
		    } 
		}
		else displayMainMenu(inventory);
		
	
}


	public static int getSpaceLeftInInventory(Appliance[] inventory) {
		int spaceLeft = inventory.length;
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] != null) {
				spaceLeft--;
			}
		}
		return spaceLeft;
	}

	public static void createNewAppliances(Appliance[] inventory) {
		globalAttempts = 0;
		System.out.println("How many new appliances you want to create?");
		int newAppliances = keyboard.nextInt();
		int leftSpaceInInventory = getSpaceLeftInInventory(inventory);

		if (newAppliances < leftSpaceInInventory) {
			for (int s = newAppliances; s > 0; s--) {
				inventory[leftSpaceInInventory - 1] = new Appliance();
				System.out.println(inventory[leftSpaceInInventory - 1]);
				leftSpaceInInventory--;
			}
			displayMainMenu(inventory);
		} else {
			System.out.println("There are " + leftSpaceInInventory + " spaces you can add.");
		}
	}

	

	public static void findAppliancesBy(String brand, Appliance inventory[]) {
		for (int i = 0; i < space; i++) {
			if (inventory[i].getbrand() == brand) {
				System.out.println(inventory[i]);
			}
		}
	}

	public static void findCheaperThan(Double price, Appliance inventory[]) {
		for (int i = 0; i < space; i++) {
			if (inventory[i].getprice() < price) {
				System.out.println(inventory[i]);
			}
		}
	}

}

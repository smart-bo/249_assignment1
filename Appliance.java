
	//------------------------------------------
		// Written by: Zhang Bo   ID:40108654
		// For COMP 249 E - Fall 2019
		// Assignment1
		// Due Date:2019-SEP-27
		//------------------------------------------

		/*This program is create Appliance class.
		 *Define the constructors
		 *Create several methods 
		 * */

		package asssignment1;

		public class Appliance {
			 private String brand; 
			 private String type; 
			 private double price; 
			 private long SN;
			 
			 public static long SNcount=1000000;
			 
			 public Appliance()
			 {
				 this.brand="LG";
				 this.type="Fridge";
				 this.price=1;
				 this.SN=SNcount;
				 SNcount++;
			 }
			 public Appliance(double price)
			 {
				 this.brand="LG";
				 this.type="Fridge";
				 this.price=price;
				 this.SN=SNcount;
				 SNcount++;
			 }
			 public Appliance(String brand,String type,double price)
			 {
				 this.brand=brand;
				 this.type=type;
				 this.price=price;
				 this.SN=SNcount;
				 SNcount++;
			 }
			 public Appliance(Appliance a) {
				 this.brand=a.brand;
				 this.type=a.type;
				 this.price=a.price;
				 this.SN=SNcount;
				 SNcount++;
			 }
			 public String getbrand() {
				 return brand;
			 }
			 public String gettype() {
				 return type;
			 }
			 public double getprice() {
				 return price;
			 }
			 public long getSN() {
				 return SN;
			 }
			 public void setprice(double price) {
				 this.price=price;
			 }
			 public void setbrand(String brand) {
				 this.brand=brand;
			 }
			 public void settype(String type) {
				 this.type=type;
			 }
			 
			 public String toString() {
				 return("This Appliance is "+type+", brand is "+brand+",price is "+price+" SN is "+SN);
			 }
			 
			 public int findNumberOfCreatedAppliances() {
				 return (int) (SNcount-1000000);
			 }
			 public boolean equals(Appliance a) {
				  return (this.brand==a.brand&&this.type==a.type&&this.price==a.price);
			 }
		}



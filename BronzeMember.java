package groceryStore;

public class BronzeMember extends Member {

	private double gasPurchases; // the amount that the member spent on gas in the year
	private double groceryPurchases; //the amount that the member spent on groceries in the year
	private double everydayPurchases; //the amount that the member spent on everyday purchases in the year

	public BronzeMember(String name, int age, int yearsMember, String phone, boolean goodStanding, int memberID,
			int monthJoined, int yearJoined, double gasPurchases, double groceryPurchases, double everydayPurchases) throws BadMember {
		super(name, age, yearsMember, phone, goodStanding, memberID, monthJoined, yearJoined);
		setGasPurchases(gasPurchases);
		setGroceryPurchases(groceryPurchases);
		setEverydayPurchases(everydayPurchases);
		setDues(calculateDues());
	}

	/**
	 * Converts class information to readable String format
	 * 
	 * @return s A String representation of the Class information
	 */
	@Override
	public String toString() {
		String membershipType = "Bronze";
		
		String s = super.toString() + "\n\n" + "Membership Type: " + membershipType + "\n"
				+ "Gas Purchases: " + gasPurchases + "\n"
				+ "Grocery Purchases: " + groceryPurchases + "\n"
				+ "Everyday Purchases: " + everydayPurchases + "\n"
				+ "Cash Back: " + calculateCashBack();
		return s;
	}
	
	/**
	 * Calculates the cash back for the member's purchases
	 * 
	 * @return cashBack The cash back for the member's purchases
	 */
	@Override
	double calculateCashBack() {
		double cashBack = (gasPurchases * 0.02) + (groceryPurchases * 0.01) + (everydayPurchases * 0.05);
		return cashBack;
	}

	/**
	 * Calculates the member's dues
	 * 
	 * @return setDues The member's dues
	 */
	@Override
	double calculateDues() {
		double setDues = 50;
		return setDues;
	}
	
	/**
	 * Returns the member's gas purchases
	 * 
	 * @return gasPurchases The member's gas purchases
	 */
	public double getGasPurchases() {
		return gasPurchases;
	}
	
	/**
	 * Returns the member's grocery purchases
	 * 
	 * @return groceryPurchases The member's grocery purchases
	 */
	public double getGroceryPurchases() {
		return groceryPurchases;
	}
	
	/**
	 * Returns the member's everyday purchases
	 * 
	 * @return everydayPurchases The member's everyday purchases
	 */
	public double getEverydayPurchases() {
		return everydayPurchases;
	}

	/**
	 * Sets the member's gas purchases
	 * 
	 * @param gasPurchases The member's gas purchases
	 */
	public void setGasPurchases(double gasPurchases) {
		this.gasPurchases = gasPurchases;
	}
	
	/**
	 * Sets the member's grocery purchases
	 * 
	 * @param groceryPurchases The member's grocery purchases
	 */
	public void setGroceryPurchases(double groceryPurchases) {
		this.groceryPurchases = groceryPurchases;
	}
	
	/**
	 * Sets the member's everyday purchases
	 * 
	 * @param everydayPurchases The member's everyday purchases
	 */
	public void setEverydayPurchases(double everydayPurchases) {
		this.everydayPurchases = everydayPurchases;
	}
}

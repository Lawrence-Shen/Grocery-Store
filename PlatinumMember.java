package groceryStore;

public class PlatinumMember extends Member {
	
	private double entertainmentPurchases; //the amount the member has spent on entertainment in the year
	private double recurringPurchases; //the amount the member has spent on recurring purchases in the year
	private double transportationPurchases; //the amount the member has spent on transportation in the year
	
	public PlatinumMember(String name, int age, int yearsMember, String phone, boolean goodStanding, int memberID,
			int monthJoined, int yearJoined, double entertainmentPurchases, double recurringPurchases, double transportationPurchases) throws BadMember {
		super(name, age, yearsMember, phone, goodStanding, memberID, monthJoined, yearJoined);
		setEntertainmentPurchases(entertainmentPurchases);
		setRecurringPurchases(recurringPurchases);
		setTransportationPurchases(transportationPurchases);
		setDues(calculateDues());
	}
	
	/**
	 * Converts class information to readable String format
	 * 
	 * @return s A String representation of the Class information
	 */
	@Override
	public String toString() {
		String membershipType = "Premium";
		
		String s = super.toString() + "\n\n" + "Membership Type: " + membershipType + "\n"
				+ "Entertainment Purchases: " + entertainmentPurchases + "\n"
				+ "Recurring Purchases: " + recurringPurchases + "\n"
				+ "Transportation Purchases: " + transportationPurchases + "\n"
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
		double cashBack = (entertainmentPurchases * 0.02) + (recurringPurchases * 0.01) + (transportationPurchases * 0.05);
		return cashBack;
	}

	/**
	 * Calculates the member's dues.
	 * If member has been in good standing for over 10 years, they receive a 20% discount
	 * 
	 * @return setDues The member's dues
	 */
	@Override
	double calculateDues() {
		double setDues = 150;
		if (getGoodStanding() && (getYearsMember() > 10)) {
			setDues *= 0.8;
		}
		return setDues;
	}
	
	/**
	 * Returns the member's entertainment purchases
	 * 
	 * @return entertainmentPurchases The member's entertainment purchases
	 */
	public double getEntertainmentPurchases() {
		return entertainmentPurchases;
	}
	
	/**
	 * Returns the member's recurring purchases
	 * 
	 * @return recurringPurchases The member's recurring purchases
	 */
	public double getRecurringPurchases() {
		return recurringPurchases;
	}
	
	/**
	 * Returns the member's transportation purchases
	 * 
	 * @return transportationPurchases The member's transportation purchases
	 */
	public double getTransportationPurchases() {
		return transportationPurchases;
	}

	/**
	 * Sets the member's entertainment purchases
	 * 
	 * @param entertainmentPurchases The member's entertainment purchases
	 */
	public void setEntertainmentPurchases(double entertainmentPurchases) {
		this.entertainmentPurchases = entertainmentPurchases;
	}
	
	/**
	 * Sets the member's recurring purchases
	 * 
	 * @param recurringPurchases The member's recurring purchases
	 */
	public void setRecurringPurchases(double recurringPurchases) {
		this.recurringPurchases = recurringPurchases;
	}
	
	/**
	 * Sets the member's transportation purchases
	 * 
	 * @param transportationPurchases The member's transportation purchases
	 */
	public void setTransportationPurchases(double transportationPurchases) {
		this.transportationPurchases = transportationPurchases;
	}
	
	/**
	 * Sets the number of years member has been as member.
	 * Also recalculates dues to check if Platinum Member is eligible for annual fee discount
	 * 
	 * @param yearsMember The number of years member has been as member
	 */
	@Override
	public void setYearsMember(int yearsMember) {
		super.setYearsMember(yearsMember);
		setDues(calculateDues());
	}
	
	/**
	 * Sets if the member is in good standing (if they have paid their membership fee).
	 * Also recalculates dues to check if Platinum Member is eligible for annual fee discount
	 * 
	 * @param goodStanding If the member is in good standing (if they have paid their membership fee)
	 */
	@Override
	public void setGoodStanding(boolean goodStanding) {
		super.setGoodStanding(goodStanding);
		setDues(calculateDues());
	}
}

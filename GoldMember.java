package groceryStore;

public class GoldMember extends Member {

	private double restaurantPurchases; //the amount that the member spent at restaurants in the year
	private double travelPurchases; //the amount that the member spent on travel in the year
	
	public GoldMember(String name, int age, int yearsMember, String phone, boolean goodStanding, int memberID,
			int monthJoined, int yearJoined, double restaurantPurchases, double travelPurchases) throws BadMember {
		super(name, age, yearsMember, phone, goodStanding, memberID, monthJoined, yearJoined);
		setRestaurantPurchases(restaurantPurchases);
		setTravelPurchases(travelPurchases);
		setDues(calculateDues());
	}

	/**
	 * Converts class information to readable String format
	 * 
	 * @return s A String representation of the Class information
	 */
	@Override
	public String toString() {
		String membershipType = "Gold";
		
		String s = super.toString() + "\n\n" + "Membership Type: " + membershipType + "\n"
				+ "Restaurant Purchases: " + restaurantPurchases + "\n"
				+ "Travel Purchases: " + travelPurchases + "\n"
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
		double cashBack = (restaurantPurchases * 0.02) + (travelPurchases * 0.05);
		return cashBack;
	}

	/**
	 * Calculates the member's dues
	 * 
	 * @return setDues The member's dues
	 */
	@Override
	double calculateDues() {
		double setDues = 100;
		return setDues;
	}
	
	/**
	 * Returns the member's restaurant purchases
	 * 
	 * @return restaurantPurchases The member's restaurant purchases
	 */
	public double getRestaurantPurchases() {
		return restaurantPurchases;
	}
	
	/**
	 * Returns the member's travel purchases
	 * 
	 * @return travelPurchases The member's travel purchases
	 */
	public double getTravelPurchases() {
		return travelPurchases;
	}
	
	/**
	 * Sets the member's restaurant purchases
	 * 
	 * @param restaurantPurchases The member's restaurant purchases
	 */
	public void setRestaurantPurchases(double restaurantPurchases) {
		this.restaurantPurchases = restaurantPurchases;
	}
	
	/**
	 * Sets the member's travel purchases
	 * 
	 * @param travelPurchases The member's travel purchases
	 */
	public void setTravelPurchases(double travelPurchases) {
		this.travelPurchases = travelPurchases;
	}

}

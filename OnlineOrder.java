package groceryStore;

import java.util.ArrayList;

public class OnlineOrder implements Comparable<OnlineOrder>{

	private Member member; //the member who is placing the order
	private double costOrder; //the cost of the order
	private int numItems; //the number of items in the order
	private ArrayList<GroceryItem> basketItems; //an ArrayList of items in the customer's basket 
	
	public OnlineOrder(Member member, ArrayList<GroceryItem> basketItems) throws BadGrocery {
		setMember(member);
		setBasketItems(basketItems);
		setNumItems();
		totalCostBasket();
	}
	
	/**
	 * Converts class information to readable String format
	 * 
	 * @return s A String representation of the Class information
	 */
	@Override
	public String toString() {
		String s = "Member: " + "\n" + member.toString() + "\n\n" 
				+ "Cost of Order: " + costOrder +"\n" + "Number of Items: " + numItems + "\n" 
				+ "Items: " + "\n" + basketItems.toString();
		return s;
	}
	
	@Override
	public int compareTo(OnlineOrder order) {
		return Double.compare(this.costOrder, order.costOrder);
	}
	
	/**
	 * Checks if the all item's in the customer's basket are in stock.
	 *
	 * @return checkInventory Boolean value, true if the all item's in the customer's basket are in stock, false otherwise
	 */
	public boolean checkInventory(ArrayList<GroceryItem> basketItems) {
		for(GroceryItem g : basketItems) {
			if (g.getInventory() == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Calculates the total cost of the items in the order basket. 
	 * Acts as an initializer for costOrder variable.
	 * No returns, stores value in costOrder, a class variable
	 */
	public void totalCostBasket() {
		costOrder = 0;
		for(GroceryItem g : basketItems) {
			costOrder += g.getPrice();
		}
	}

	/**
	 * Returns the member placing the order
	 * 
	 * @return member The member placing the order
	 */
	public Member getMember() {
		return member;
	}
	
	/**
	 * Returns the total cost of the order
	 * 
	 * @return costOrder The total cost of the order
	 */
	public double getCostOrder() {
		return costOrder;
	}
	
	/**
	 * Returns the number of items in the order
	 * 
	 * @return numItems The number of items in the order
	 */
	public int getNumItems() {
		numItems = basketItems.size();
		return numItems;
	}
	
	/**
	 * Returns the list of items in the order
	 * 
	 * @return basketItems The list of items in the order
	 */
	public ArrayList<GroceryItem> getBasketItems() {
		return basketItems;
	}
	
	/**
	 * Sets the member object that's placing the order
	 * 
	 * @param member The member object that's placing the order
	 */
	public void setMember(Member member) {
		this.member = member;
	}
	
	/**
	 * Sets the number of items in the order
	 * 
	 * @param numItems The number of items in the order
	 */
	public void setNumItems() {
		numItems = basketItems.size();
	}
	
	/**
	 * Sets the list of items in the order.
	 * Calls totalCostBasket() to calculate cost of the order
	 * 
	 * @param basketItems ArrayList of items
	 */
	public void setBasketItems(ArrayList<GroceryItem> basketItems) throws BadGrocery {
		if(!checkInventory(basketItems)) {
			throw new BadGrocery("Not all the items on the list are in stock!");
		}
		this.basketItems = basketItems;
		totalCostBasket();
		setNumItems();	
	}
}

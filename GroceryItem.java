package groceryStore;

public class GroceryItem {
	
	private String itemName; //the name of the item
	private double price; //the price of the item (this value must be greater than $0)
	private int inventory; //how many units of the item is in stock in inventory
	private int SKU; //the SKU (barcode number) for the item
	private GroceryCategory itemCategory; //the category of the item
	
	public GroceryItem(String itemName, double price, int inventory, int SKU, GroceryCategory itemCategory) throws BadGrocery {
		setItemName(itemName);
		setPrice(price);
		setInventory(inventory);
		setSKU(SKU);
		setItemCategory(itemCategory);
	}
	
	/**
	 * Converts class information to readable String format
	 * 
	 * @return s A String representation of the Class information
	 */
	@Override
	public String toString() {
		String s = "Item Name: " + itemName + ", Price: " + price
				+ ", Units in stock: " + inventory + ", Barcode Number: " + SKU 
				+ ", Item Category: " + itemCategory + "\n";
		return s;
	}
	
	/**
	 * Returns the item's name
	 * 
	 * @return itemName The item's name
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * Returns the item's price
	 * 
	 * @return price The item's price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Returns the amount of the item in inventory
	 * 
	 * @return inventory The amount of the item in inventory
	 */
	public int getInventory() {
		return inventory;
	}
	
	/**
	 * Returns the item's SKU code
	 * 
	 * @return SKU The item's SKU code
	 */
	public int getSKU() {
		return SKU;
	}

	/**
	 * Returns the item's Category
	 * 
	 * @return itemCategory The item's Category
	 */
	public GroceryCategory getItemCategory() {
		return itemCategory;
	}
	
	/**
	 * Sets the item's name
	 * 
	 * @param itemName the item's name
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	/**
	 * Sets the item's price
	 * 
	 * @param price the item's price
	 * @throws BadGrocery If the item's price is set to 0 or below
	 */
	public void setPrice(double price) throws BadGrocery {
		if (price <= 0) {
			throw new BadGrocery("The item's price must be greater than $0");
		}
		this.price = price;
	}
	
	/**
	 * Sets the amount of the item in inventory
	 * 
	 * @param inventory The amount of the item in inventory
	 */
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
	/**
	 * Sets the item's SKU code
	 * 
	 * @param SKU The item's SKU code
	 */
	public void setSKU(int SKU) {
		this.SKU = SKU;
	}
	
	/**
	 * Sets the item's category
	 * 
	 * @param itemCategory The item's category
	 */
	public void setItemCategory(GroceryCategory itemCategory) {
		this.itemCategory = itemCategory;
	}
	
}

//This program stores information for a membership grocery store. It maintains records of the customers who have purchased a 
//membership to the store, online orders placed by members, and the store’s inventory.

package groceryStore;

import java.util.ArrayList;

public class Store {
	//Testing various methods of the classes within groceryStore
	public static void main(String[] args) throws BadMember, BadGrocery {
		ArrayList<Member> memberDB = new ArrayList<Member>();
		
		//**Platinum Member without Discount**		
		PlatinumMember platinumJoe = new PlatinumMember("Platinum Joe", 55, 5, "555-555-5555", false, 11111, 5, 2022, 5000, 2000, 1000);
//		platinumJoe.setAge(12); //Exception: Age needs to be over 18
//		platinumJoe.setMonthJoined(18); //Exception: Month joined must be between 1 and 12
//		platinumJoe.setYearJoined(1988); //Exception: Year joined must be greater than or equal to 2013
		
		//**Testing setters for Member Class
		platinumJoe.setAge(77);
		platinumJoe.setGoodStanding(true);
		platinumJoe.setMemberID(22222);
		platinumJoe.setName("Platinum Joey");
		platinumJoe.setPhone("888-888-8888");
		platinumJoe.setYearJoined(2088);
		platinumJoe.setYearsMember(11);
		platinumJoe.setMonthJoined(1);
		platinumJoe.setRecurringPurchases(3000);
		platinumJoe.setTransportationPurchases(8000);
		platinumJoe.setEntertainmentPurchases(1000);
		Member platinumJoeNew = (Member) platinumJoe; //Now has dues discount
		memberDB.add(platinumJoeNew);
		
		//**Normal Gold Member**		
		GoldMember goldJoe = new GoldMember("Gold Joe", 55, 5, "555-555-5555", false, 11111, 5, 2022, 5000, 2000);
		goldJoe.setRestaurantPurchases(60000);
		goldJoe.setTravelPurchases(80000);
		Member goldJoeNew = (Member) goldJoe;
		memberDB.add(goldJoeNew);
		
		//**Normal Bronze Member**
		BronzeMember bronzeJoe = new BronzeMember("Bronze Joe", 55, 11, "555-555-5555", false, 11111, 5, 2022, 5000, 2000, 1000);
		bronzeJoe.setEverydayPurchases(50);
		bronzeJoe.setGasPurchases(20);
		bronzeJoe.setGroceryPurchases(90);
		Member bronzeJoeNew = (Member) bronzeJoe;
		memberDB.add(bronzeJoeNew);
		
		for(Member element : memberDB) {
			System.out.print(element);
			System.out.println();
			System.out.println("_________________________________");
			System.out.println();
		}
		
		//**Testing Grocery Items and Orders
		ArrayList<GroceryItem> order = new ArrayList<GroceryItem>();
		GroceryItem tomato = new GroceryItem("Tomato", 10, 200, 6028, GroceryCategory.PRODUCE);
		order.add(tomato);
		GroceryItem toiletPaper = new GroceryItem("Toilet Paper", 20, 5, 3052, GroceryCategory.MISCELLANEOUS);
		order.add(toiletPaper);
		GroceryItem porkChop = new GroceryItem("Pork Chop", 5, 50, 3455, GroceryCategory.MEAT);
		order.add(porkChop);
		GroceryItem milk = new GroceryItem("Milk", 500, 555, 3952, GroceryCategory.DAIRY);
		order.add(milk);
//		GroceryItem chocolate = new GroceryItem("Chocolate", -12, 19, 3345, GroceryCategory.MISCELLANEOUS); //Exception: Price must be greater than 0
		
//		GroceryItem cheese = new GroceryItem("Cheese", 13, 0, 3345, GroceryCategory.MISCELLANEOUS);		
//		order.add(cheese); //Exception: Not all items in the list are in stock!
		
		OnlineOrder newOrder = new OnlineOrder(platinumJoeNew, order);
		System.out.print(newOrder);
		System.out.println();
		System.out.println("_________________________________");
		System.out.println();
		
		//**Testing .compareTo() methods
		System.out.println(platinumJoeNew.compareTo(bronzeJoeNew)); //Equal value - prints 0
		bronzeJoeNew.setYearsMember(18);
		System.out.println(platinumJoeNew.compareTo(bronzeJoeNew)); //platinumJoeNew now less than bronzeJoeNew - prints (-1)
		bronzeJoeNew.setYearsMember(9);
		System.out.println(platinumJoeNew.compareTo(bronzeJoeNew)); //platinumJoeNew now greater than bronzeJoeNew - prints 1
		System.out.println();
		
		OnlineOrder newOrder2 = new OnlineOrder(bronzeJoeNew, order);
		System.out.println(newOrder.compareTo(newOrder2)); //Equal value - prints 0
		order.add(porkChop);
		newOrder2.setBasketItems(order);
		System.out.println(newOrder.compareTo(newOrder2)); //newOrder now less than newOrder2 - prints (-1)
		order.remove((order.size() - 1));
		order.remove((order.size() - 1));
		newOrder2.setBasketItems(order);
		System.out.println(newOrder.compareTo(newOrder2)); //newOrder now greater than newOrder2 - prints (-1)
	}
}

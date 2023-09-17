package groceryStore;

public abstract class Member implements Comparable<Member>{
	private String name; //the name of the membership holder
	private int age; //the age of the membership holder
	private int yearsMember; //the number of years that the customer has been a member
	private String phone; //the member's telephone number
	private boolean goodStanding; //true if the customer's membership is paid
	private int memberID; //the member's ID
	private int monthJoined; //month that the member joined (this value must be between 1 and 12)
	private int yearJoined; //the year that the member joined (this must be greater than or equal to 2013 -- the year the store opened)
	private double dues; //the annual fee for the customer's membership

	public Member(String name, int age, int yearsMember, String phone, boolean goodStanding, int memberID, int monthJoined, int yearJoined) throws BadMember{
		setName(name);
		setAge(age);
		setYearsMember(yearsMember);
		setPhone(phone);
		setGoodStanding(goodStanding);
		setMemberID(memberID);
		setMonthJoined(monthJoined);
		setYearJoined(yearJoined);
	}
	
	/**
	 * Converts class information to readable String format
	 * 
	 * @return s A String representation of the Class information
	 */
	@Override
	public String toString() {
		String goodStandingString = "Yes";
		
		if(!goodStanding) {
			goodStandingString = "No";
		}
		
		String s = "Member's name: " + name + "\n" + "Age: " + age +"\n"
				+ "Number of Years as a Member: " + yearsMember + "\n" 
				+ "Phone Number: " + phone + "\n" + "Membership Paid: " + goodStandingString + "\n" 
				+ "Member ID: " + memberID + "\n" + "Month Joined: " + monthJoined + "\n" 
				+ "Year Joined: " + yearJoined + "\n" + "Annual Membership Fee: " + dues;
		return s;
	}
	
	@Override
	public int compareTo(Member member) {
		return Integer.compare(this.yearsMember, member.yearsMember);
	}
	
	abstract double calculateCashBack(); //calculates the member's cashback amount
	abstract double calculateDues(); //calculates the member's annual membership fee
	
	/**
	 * Returns the member's name
	 * 
	 * @return name The member's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the member's age
	 * 
	 * @return age The member's age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Returns the number of years the member has been a member
	 * 
	 * @return yearsMember The number of years the member has been a member
	 */
	public int getYearsMember() {
		return yearsMember;
	}
	
	/**
	 * Returns the member's phone number
	 * 
	 * @return phone The member's phone number
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Returns if the member's is in good standing (if they have paid their membership dues)
	 * 
	 * @return goodStanding True if the member's is in good standing (if they have paid their membership dues)
	 */
	public boolean getGoodStanding() {
		return goodStanding;
	}
	
	/**
	 * Returns the member's Membership ID
	 * 
	 * @return memberID The member's Membership ID
	 */
	public int getMemberID() {
		return memberID;
	}
	
	/**
	 * Returns the month the member became a member
	 * 
	 * @return monthJoined The month the member became a member
	 */
	public int getMonthJoined() {
		return monthJoined;
	}
	
	/**
	 * Returns the year the member became a member
	 * 
	 * @return yearJoined The month the member became a member
	 */
	public int getYearJoined() {
		return yearJoined;
	}
	
	/**
	 * Returns the member's membership dues
	 * 
	 * @return dues The member's membership dues
	 */
	public double getDues() {
		return dues;
	}
	
	/**
	 * Sets the member's name
	 * 
	 * @param name The member's name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the member's age
	 * 
	 * @param age The member's age
	 * @throws BadMember If age entered is less than 18
	 */
	public void setAge(int age) throws BadMember {
		if (age < 18) {
			throw new BadMember("A member must be 18 years or older.");
		}
		this.age = age;
	}
	
	/**
	 * Sets the number of years the member has been a member
	 * 
	 * @param yearsMember The number of years the member has been a member
	 */
	public void setYearsMember(int yearsMember) {
		this.yearsMember = yearsMember;
	}
	
	/**
	 * Sets the member's phone number
	 * 
	 * @param phone The member's phone number
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Sets goodStanding true if the member's is in good standing (if they have paid their membership dues)
	 * 
	 * @param goodStanding Boolean - true if the member's is in good standing (if they have paid their membership dues)
	 */
	public void setGoodStanding(boolean goodStanding) {
		this.goodStanding = goodStanding;
	}
	
	/**
	 * Sets the member's membership ID
	 * 
	 * @param memberID The member's membership ID
	 */
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	
	/**
	 * Sets the month the member became a member
	 * 
	 * @param monthJoined the month the member became a member
	 * @throws BadMember If the month entered is less than 1 or greater than 12
	 */
	public void setMonthJoined(int monthJoined) throws BadMember{
		if (monthJoined < 1 || monthJoined > 12) {
			throw new BadMember("Month joined must be between 1 and 12");	
		}
		this.monthJoined = monthJoined;
	}
	
	/**
	 * Sets the year the member became a member
	 * 
	 * @param yearJoined The year the member became a member
	 * @throws BadMember If the year entered is less than 2013 - the year the store opened
	 */
	public void setYearJoined(int yearJoined) throws BadMember {
		if (yearJoined < 2013) {
			throw new BadMember("Year joined must be greater than or equal to 2013 -- the year the store opened");
		}
		this.yearJoined = yearJoined;
	}
	
	/**
	 * Sets the member's membership dues
	 * 
	 * @param dues The member's membership dues
	 */
	protected void setDues(double dues) {
		this.dues = dues;
	}
}

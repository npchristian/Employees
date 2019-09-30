public class Employee{
	
	protected int ID;
	protected String first_name, last_name;
	protected double hourly_rate, overtime, total_pay;		//basic employee information

	protected void print_pay(double hours)
	{
		if (hours<=40)
			total_pay=hourly_rate*hours;								//pay for no overtime
	
		
		else 
		{
			overtime=(hours-40)*hourly_rate*1.5;
			total_pay=hourly_rate*40+(hours-40)*hourly_rate*1.5;			//To account for overtime
		}
			
		System.out.println("ID " + ID + "\tCheck Amount: " + total_pay);	//print pay
	}

}
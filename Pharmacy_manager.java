public class Pharmacy_manager extends Staff_pharmacist{
	
	private boolean leadership=true;
		
	public Pharmacy_manager (String [] data)
	{
		super(data);		//call base constructor
		hourly_rate=50;		//set pay rate
	}
	
	public void print_data()
	{
		System.out.println("ID " + ID + "\tName: " + first_name + " " + last_name + "\tRate " + hourly_rate + "\tHas Leadership: " + leadership + "\tLicensed: " + licensed);	//print employee
	}
	
}
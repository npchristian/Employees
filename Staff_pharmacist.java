public class Staff_pharmacist extends Employee{
	
	protected boolean licensed=true;
		
	public Staff_pharmacist (String [] data)
	{
		ID= Integer.valueOf(data[1]);	//get name, rate, id
		first_name=data[2];
		last_name=data[3];
		hourly_rate=40;

	}
	
	public void print_data()
	{
		System.out.println("ID " + ID + "\tName: " + first_name + " " + last_name + "\tRate " + hourly_rate + "\tLicensed: " + licensed);	//print employee
	}
	
}
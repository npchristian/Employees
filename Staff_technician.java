public class Staff_technician extends Employee{
	
	protected boolean degree=true;	//default to true
	
	public Staff_technician (String [] data)
	{
		ID= Integer.valueOf(data[1]);	//get name, rate, and ID
		first_name=data[2];
		last_name=data[3];
		hourly_rate = 20;
	}
	public void print_data()
	{
		System.out.println("ID " + ID + "\tName: " + first_name + " " + last_name + "\tRate " + hourly_rate + "\thas degree: " + degree);	//print employee
	}
}	
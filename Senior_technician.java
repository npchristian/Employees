Skip to content
Enterprise
Search or jump to…

Pull requests
Issues
Explore
@nchristiSign out
0
00nchristi/csci24000_fall2017_A5 Private
 Code Issues 0 Pull requests 0 Projects 0 Wiki Insights Settings
csci24000_fall2017_A5/Senior_technician.java
24d56f5 on Nov 17, 2017
 Nathan Christian Final version:
   
23 lines (18 sloc)  695 Bytes
//	Honor  Pledge:  I  pledge that I have neither given nor received
//	Any help on this assignment.
//	nchristi (Nathan Christian)
//	Senior_technician.java -> Assignment 5
//	Created by Nathan Christian
//	Version 1.3

public class Senior_technician extends Staff_technician{
	
	private boolean service_award=true;	//set default to true. 
	
	
	public Senior_technician (String [] data)
	{
		super(data);	//call base constructor
		hourly_rate=25;	//set hours worked
	}
	
	public void print_data()
	{
		System.out.println("ID " + ID + "\tName: " + first_name + " " + last_name + "\tRate " + hourly_rate + "\tHas Service Award: " + service_award + "\tHas degree: "+ degree);	 //print employee
	}
}
© 2019 GitHub, Inc.
Help
Support
API
Training
Blog
About
GitHub Enterprise Server 2.16.12
Press h to open a hovercard with more details.
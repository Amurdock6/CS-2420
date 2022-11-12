package assign09;

import java.text.DecimalFormat;

/**
 * This class provides a simple representation for a University of Utah student.
 * Object's hashCode method is overridden with a correct hash function for this
 * object, but one that does a good job of distributing students in a hash
 * table.
 * 
 * @author Erin Parker & Todd Oldham & Alex Murdock
 * @version 11/10/2022
 */
public class StudentGoodHash 
{

	private int uid;
	private String firstName;
	private String lastName;

	/**
	 * Creates a new student with the specified uid, firstName, and lastName.
	 * 
	 * @param uid
	 * @param firstName
	 * @param lastName
	 */
	public StudentGoodHash(int uid, String firstName, String lastName) 
	{
		this.uid = uid;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return the UID for this student object
	 */
	public int getUid() 
	{
		return this.uid;
	}

	/**
	 * @return the first name for this student object
	 */
	
	public String getFirstName() 
	{
		return this.firstName;
	}
 
	/**
	 * @return the last name for this student object
	 */
	public String getLastName() 
	{
		return this.lastName;
	}

	/**
	 * @return true if this student and 'other' have the same UID, first name, and last name; false otherwise
	 */
	public boolean equals(Object other) 
	{
		if(!(other instanceof StudentGoodHash))
			return false;

		StudentGoodHash rhs = (StudentGoodHash) other;

		return this.uid == rhs.uid && this.firstName.equals(rhs.firstName) && this.lastName.equals(rhs.lastName);
	}
	
	/**
	 * @return a textual representation of this student
	 */
	public String toString() 
	{
		DecimalFormat formatter = new DecimalFormat("0000000");
		return firstName + " " + lastName + " (u" + formatter.format(uid) + ")";
	}

	/**
	 * 
	 * For the hashCode here it takes the value of the the uid, 
	 * the value of the first name squared, and
	 * the value of the last name squared then adds them together and returns it.
	 * 
	 */
	public int hashCode() 
	{
		// initialize variables
		int totalValue = 0;
		int totalValueString1 = 0;
		int totalValueString2 = 0;
		
		// get the value of each character in the first name and add them together
		for (int i = 0; i < firstName.length(); i++)
			totalValueString1 += firstName.charAt(i);
		
		// get the value of each character in the last name and add them togeter
		for (int j = 0; j < lastName.length(); j++)
			totalValueString2 += lastName.charAt(j);
		
		// get the final value
		totalValue = uid + totalValueString1 * totalValueString1 + totalValueString2 * totalValueString2;
		
		if(totalValue == Integer.MIN_VALUE)
			totalValue++;
		
		Math.abs(totalValue);
		
		return totalValue;
	}
}

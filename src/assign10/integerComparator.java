package assign10;

import java.util.Comparator;

public class integerComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer number1, Integer number2) 
	{
		return number1.compareTo(number2);
	}

}

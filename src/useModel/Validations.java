package useModel;

import java.text.DecimalFormat;

// 1 -> success
// 2 -> failure

public class Validations {
	public static int dateValidation(String transactionDate)
	{
		String day = transactionDate.substring(0, 2);
		String month = transactionDate.substring(2, 4);
		String year = transactionDate.substring(4,8);
		 
		int intday=Integer.parseInt(day);
		int intmonth = Integer.parseInt(month);
		int intyear = Integer.parseInt(year);
		
		if(intday == 2 && intmonth == 1 && intyear == 2018) 
		{
			return 1;
		}
		
		else
		{
			return 0;
		}
		
	}
	
	public static int transactionRefValidation(String transactionRef)
	{
		String s = transactionRef;
		 
        boolean isAlphaNumeric = s != null && s.chars().allMatch(Character::isLetterOrDigit);
        if(isAlphaNumeric == true)
        {
        	return 1;
        }
        else
        {
        	return 0;
        }
	}
	
	public static int nameValidation(String name)
	{
		String n = name;
		boolean isAlphaNumeric = n != null && n.chars().allMatch(Character::isLetterOrDigit);
        if(isAlphaNumeric == true)
        {
        	return 1;
        }
        else
        {
        	return 0;
        }
	}
	
	public static int accountValidation(String accountNo)
	{
		String a = accountNo;
		boolean isAlphaNumeric = a != null && a.chars().allMatch(Character::isLetterOrDigit);
        if(isAlphaNumeric == true)
        {
        	return 1;
        }
        else
        {
        	return 0;
        }
	}
	
	public static double amountValidation(String amount)
	{
		int flag = -1;
		try {
	         
	         Double doub = Double.parseDouble(amount);
	         flag = 1;
	        // System.out.println("Value of the variable: "+amount);
	      }catch (NumberFormatException ex) {
	    	  flag = 0;
	         System.out.println("Amount is not a Number!!!");
	      }
		
		if(flag == 1)
		{
			double amt = Double.parseDouble(amount);
			if(amt > 0)
			{
				DecimalFormat df = new DecimalFormat("#.00");
			    String amtFormated = df.format(amt);
			    //System.out.println("Valid amount : " + amtFormated);
			    amt = Double.parseDouble(amtFormated);
			    return amt;
			    
			}
			else
			{
				
				return 0;
			}
			
		}
		else
		{
			return 0;
		}
	}

}

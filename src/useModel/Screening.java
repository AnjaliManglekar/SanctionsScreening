package useModel;

import java.util.Arrays;

public class Screening {
	public static int fishynamesValidation(String name)
	{
		String n=name;
		boolean x=((n.equalsIgnoreCase("VijayMallya")) || (n.equalsIgnoreCase("Neeshal Modi")) || (n.equalsIgnoreCase("Mehul Choksi")) || (n.equalsIgnoreCase("NiravModi")) || (n.equalsIgnoreCase("JatinMehta")) ||(n.equalsIgnoreCase("LalitModi")) || (n.equalsIgnoreCase("OsamaBinaden"))||(n.equalsIgnoreCase("BernardEbbers"))||(n.equalsIgnoreCase("DhirubhaiAhambhani"))||(n.equalsIgnoreCase("NikolaiMesla")));
		 if(x==true )
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	public static int fishyaccounts(String account)
	{
		String arr[] = new String[] {"200001020111", "200001020181", "200001020237", "200001011111", "200001110181", "111156789012", "200221011111", "200007777711", "208888881111", "200002317231"};
		boolean result = Arrays.stream(arr).anyMatch(account::equals);
		if (result) {
			return 1;
		}
		return 0;
		
	}
}

package useModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.io.IOException;
import java.sql.*;


public class FileReading {

	public static void main(String[] args) throws Exception {
		File f1=new File("sample.txt"); 		
		String[] words=null;  				
		FileReader fr = new FileReader(f1); 			 
		BufferedReader br = new BufferedReader(fr); 			
		String s;     
		//int counter = 0;
		int count = 0;
		String Tref = "";
		String date = "";
		String payerName = "";
		String payerAcc = "";
		String payeeName = "";
		String payeeAcc = "";
		String amount;
		
		
		//Transaction tr[] = new Transaction[20];
		ArrayList <Transaction> tr = new ArrayList <Transaction>();
		
		while((s=br.readLine())!=null)   					
		  {
		     words=s.split(" "); 
		     Transaction t = new Transaction();
		    // counter = Transaction.counter();
		     
		      for (String word : words) 
		      {
		    	  if(!word.isEmpty())
		    	  {
		    		  count++;
			             if(count == 1)
			             {
			            	 Tref = word.substring(0, 12);
			            	 t.setTransactionRef(Tref);
			            	 
			            	 date = word.substring(12, 20);
			            	 t.setTransactionDate(date);
			            	 
			            	 payerName = word.substring(20);
			            	 t.setPayerName(payerName);
			            	 
			            	// System.out.println("Transaction Ref No. : " + Tref);
			            	// System.out.println("Value Date : " + date);
			            	// System.out.println("Payer Name : " + payerName);
			             }
			             
			             if(count == 2)
			             {
			            	 payerAcc = word.substring(0, 12);
			            	 t.setPayerAccount(payerAcc);
			            	 
			            	 payeeName = word.substring(12);
			            	 t.setPayeeName(payeeName);
			            	 
			            	// System.out.println("Payer Account : " + payerAcc);
			            	// System.out.println("Payee Name : " + payeeName);
			            	 
			             }
			             
			             if(count == 3)
			             {
			            	 payeeAcc = word.substring(0);
			            	 t.setPayeeAccount(payeeAcc);
			            	 
			            	 //System.out.println("Payee Account : " + payeeAcc);
			             }
			             
			             if(count == 4) 
			             {
			            	 amount = word;
			            	 t.setAmount(amount);
			            	 tr.add(t);
			            	 //System.out.println("Amount : " + amount);
			            	 //System.out.println("");
			            	 //System.out.println("------------------------------------------------------------------------------------");
			            	// System.out.println("");
			            	 count = 0;
			             }
		    	  }
	               
		      }
		  }
		
		/*for(Transaction T : tr)
		{
			System.out.println(T);
		}*/
		  
		  fr.close();
		  
		  
		  //JDBC for Validation
		  
		  String url = "jdbc:mysql://localhost:3306/sanctionsscreeningoftransactions";
		  String user = "root";
		  String password = "Manjali@123";
		  String pass = "pass";
		  String fail = "fail";
		  int validpass = -1;
		  
		  Class.forName("com.mysql.cj.jdbc.Driver");
			
		  Connection connection = DriverManager.getConnection(url, user, password);
		  PreparedStatement st = connection.prepareStatement("insert into Transactions(transactionRef,transactionDate,payerName,payerAccount,payeeName,payeeAccount,amount,validations,screening) values(?,?,?,?,?,?,?,?,?)");
		  
		  for(int k = 0; k < tr.size(); k++)
		  {
			  //System.out.println(tr[k]);
			  //st.setInt(1, tr[k].getPrimaryKey());
			  PreparedStatement prepareStatement=connection.prepareStatement("select * from Transactions where transactionRef='tr.get(k).getTransactionRef()'");
				ResultSet resultSet=prepareStatement.executeQuery();
				int cnt=0;
				while(resultSet.next())
				{
					cnt++;
				}
			  
			  //Transaction Reference Number Validation
			  int ref = 0;
			  ref = Validations.transactionRefValidation(tr.get(k).getTransactionRef());
			  if(ref == 1)
			  {
				  st.setString(1, tr.get(k).getTransactionRef());
			  }
			  else
			  {
				  st.setString(1, tr.get(k).getTransactionRef());
			  }
			  
			  //Transaction Date Validation
			  int dat = 0;
			  dat = Validations.dateValidation(tr.get(k).getTransactionDate());
			  if(dat == 1)
			  {
				  st.setString(2, tr.get(k).getTransactionDate());
			  }
			  else
			  {
				  st.setString(2, tr.get(k).getTransactionDate());
			  }
			  
			  //Payer Name Validation
			  int nam1 = 0;
			  nam1 = Validations.nameValidation(tr.get(k).getPayerName());
			  if(nam1 == 1)
			  {
				  st.setString(3, tr.get(k).getPayerName());
			  }
			  else
			  {
				  st.setString(3, tr.get(k).getPayerName());
			  }
			  
			  //Payer Account Validation
			  int acc1 = 0;
			  acc1 = Validations.accountValidation(tr.get(k).getPayerAccount());
			  if(acc1 == 1)
			  {
				  st.setString(4, tr.get(k).getPayerAccount());
			  }
			  else
			  {
				  st.setString(4, tr.get(k).getPayerAccount());
			  }
			  
			  
			  //Payee Name Validation
			  int nam2 = 0;
			  nam2 = Validations.nameValidation(tr.get(k).getPayeeName());
			  if(nam2 == 1)
			  {
				  st.setString(5, tr.get(k).getPayeeName());
			  }
			  else
			  {
				  st.setString(5, tr.get(k).getPayeeName());
			  }
			  
			  //Payee Account Validation
			  int acc2 = 0;
			  acc2 = Validations.accountValidation(tr.get(k).getPayeeAccount());
			  if(acc2 == 1)
			  {
				  st.setString(6, tr.get(k).getPayeeAccount());
			  }
			  else
			  {
				  st.setString(6, tr.get(k).getPayeeAccount());
			  }
			  
			  //Amount Validation
			  double amnt = 0;
			  amnt = Validations.amountValidation(tr.get(k).getAmount());
			  if(amnt != 0)
			  {
				 st.setDouble(7, amnt);
			  }
			  else
			  {
				  st.setDouble(7, amnt);
			  }
			  
			  //Validations
			  if(ref == 1 && dat == 1 && nam1 == 1 && acc1 == 1 && nam2 == 1 && acc2 == 1 && amnt != 0 && cnt == 0)
			  {
				  validpass = 0;
				  st.setString(8, pass);
			  }
			  else
			  {
				  validpass = 1;
				  st.setString(8, fail);
			  }
			  
			  //Fishy Names Screenings
			  int nam4 = 0;
			  int nam3 = 0;
			  nam3 = Screening.fishynamesValidation(tr.get(k).getPayeeName());
			  nam4 = Screening.fishynamesValidation(tr.get(k).getPayerName());
			  
			  int facc1 = 0;
			  int facc2 = 0;
			  facc1 = Screening.fishyaccounts(tr.get(k).getPayeeAccount());
			  facc2 = Screening.fishyaccounts(tr.get(k).getPayerAccount());
			  
			  //Screening
			  if(nam3 == 1 || nam4 == 1 || validpass == 1 || facc1 == 1 || facc2 == 1)
			  {
				  st.setString(9, fail);
			  }
			  else
			  {
				  st.setString(9, pass);
			  }
			  
			  st.executeUpdate();
			  
		  }
		  

	}
	

}

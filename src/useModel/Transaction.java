package useModel;

import java.sql.DriverManager;
import java.util.*;
import java.sql.*;


public class Transaction {
	private String TransactionRef;
	private String TransactionDate;
	private String PayerName;
	private String PayerAccount;
	private String PayeeName;
	private String PayeeAccount;
	private String Amount;
	private static int numb = 0;
	private int primaryKey;
	
	
	public Transaction(String transactionRef, String transactionDate, String payerName, String payerAccount,
			String payeeName, String payeeAccount, String amount) {
		super();
		TransactionRef = transactionRef;
		TransactionDate = transactionDate;
		PayerName = payerName;
		PayerAccount = payerAccount;
		PayeeName = payeeName;
		PayeeAccount = payeeAccount;
		Amount = amount;
	}

	public Transaction() {
		// TODO Auto-generated constructor stub
		numb++;
		this.primaryKey = numb;
		
	}
	
	public int getPrimaryKey() {
		return primaryKey;
	}

	public String getTransactionRef() {
		return TransactionRef;
	}

	public void setTransactionRef(String transactionRef) {
		TransactionRef = transactionRef;
	}

	public String getTransactionDate() {
		return TransactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		TransactionDate = transactionDate;
	}

	public String getPayerName() {
		return PayerName;
	}

	public void setPayerName(String payerName) {
		PayerName = payerName;
	}

	public String getPayerAccount() {
		return PayerAccount;
	}

	public void setPayerAccount(String payerAccount) {
		PayerAccount = payerAccount;
	}

	public String getPayeeName() {
		return PayeeName;
	}

	public void setPayeeName(String payeeName) {
		PayeeName = payeeName;
	}

	public String getPayeeAccount() {
		return PayeeAccount;
	}

	public void setPayeeAccount(String payeeAccount) {
		PayeeAccount = payeeAccount;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [TransactionRef=" + TransactionRef + ", TransactionDate=" + TransactionDate + ", PayerName="
				+ PayerName + ", PayerAccount=" + PayerAccount + ", PayeeName=" + PayeeName + ", PayeeAccount="
				+ PayeeAccount + ", Amount=" + Amount + "]";
	}
	
	public static int counter() {
        return numb;
    }
	
	
	
	

}
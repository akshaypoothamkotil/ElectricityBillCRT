package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
	
	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException{
		if(currentReading<0 || previousReading <0 || (previousReading>currentReading)) {
			throw new InvalidReadingException();
		}
		if(!type.equals("Commercial") && !type.equals("Domestic")) {
			throw new InvalidConnectionException();
		}
		return true;
		
	}
	
	public float calculateBillAmt(int currentReading, int previousReading, String type) {
		try {
			validate(currentReading, previousReading, type);
		}
		catch (InvalidConnectionException e) {
			return -2f;
		}
		catch (InvalidReadingException e) {
			return -1f;
		}
		if(type.equals("Commercial")) {
			float slabs[]= {5.2f,6.8f,8.3f};
			Commercial com=new Commercial(currentReading, previousReading, slabs);
			return com.computeBill();
		}
		else {
			float slabs[]= {2.3f,4.2f,5.5f};
			Domestic dom=new Domestic(currentReading, previousReading, slabs);
			return dom.computeBill();
		}
	}
	
	
	public String generateBill(int currentReading, int previousReading, String type) {
		float ret=calculateBillAmt(currentReading, previousReading, type);
		if(ret==-1f) {
			return "Incorrect Reading";
		}
		else if(ret ==-2f) {
			return "Invalid ConnectionType";
		}
		else {
			return "Amount to be paid:"+ret;
		}
	}
	
}

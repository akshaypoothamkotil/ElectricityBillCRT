package com.wipro.eb.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.wipro.eb.entity.Connection;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;
import com.wipro.eb.service.ConnectionService;

import junit.framework.Assert;

class TestConnectionService {

	ConnectionService connection=new ConnectionService();
	@Test
	void test01(){
		try {
			connection.validate(1,-2,"Domestic");
		}
		catch (InvalidReadingException e) {
			
			assertEquals("Incorrect Reading", e.toString());
		}
		catch (InvalidConnectionException e) {
			//NA
		}
	}
	@Test
	void test02() {
		try {
			
			connection.validate(2, 1, "balayya");
		}
		catch (Exception e) {
			
			assertEquals("Invalid ConnectionType",e.toString());
		}
	}
	@Test
	void test03() {
try {
			
			
			assertEquals(true,connection.validate(2, 1, "Domestic"));
		}
		catch (Exception e) {
			
			//NA
		}
	}
	@Test
	void test04() {
try {
			
			
			assertEquals(true,connection.validate(2, 1, "Commercial"));
		}
		catch (Exception e) {
			
			//NA
		}
	
	}
	
	
	
	@Test
	void test05() {
try {
			
			
			assertEquals(-2f,connection.calculateBillAmt(2, 1, "Commsercial"));
		}
		catch (Exception e) {
			
			//NA
		}
	
	}
	@Test
	void test06() {
try {
			
			
	assertEquals(-1f,connection.calculateBillAmt(240, -120, "Commercial"));
		}
		catch (Exception e) {
			
			//NA
		}
	
	}
	@Test
	void test07() {
		try {
			
			
			assertEquals(435f,connection.calculateBillAmt(240, 120, "Domestic"));
		}
		catch (Exception e) {
			
			//NA
		}
	
	}
	@Test
	void test08() {
		try {
			
			
			assertEquals("Amount to be paid:"+435f,connection.generateBill(240, 120, "Domestic"));
		}
		catch (Exception e) {
			
			//NA
		}
	
	}
	@Test
	void test09() {
		try {
			
			
			assertEquals("Invalid ConnectionType",connection.generateBill(240, 120, "DomesticConns"));
		}
		catch (Exception e) {
			
			//NA
		}
	
	}
	@Test
	void test10() {
		try {
			
			
			assertEquals("Incorrect Reading",connection.generateBill(0, 120, "DomesticConns"));
		}
		catch (Exception e) {
			
			//NA
		}
	
	}

}

package com.wipro.eb.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.wipro.eb.entity.Domestic;

class TestDomestic {

	@Test
	void test() {
		int currentReading=240;
		int previousReading=120;
		float slabs[]= {2.3f,4.2f,5.5f};
		Domestic domestic=new Domestic(currentReading, previousReading, slabs);
		assertEquals(435f, domestic.computeBill());
	}
	
}

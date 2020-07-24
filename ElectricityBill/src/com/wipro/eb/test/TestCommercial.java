package com.wipro.eb.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.wipro.eb.entity.Commercial;

class TestCommercial {

	@Test
	void test() {
		int currentReading=240;
		int previousReading=120;
		float slabs[]= {5.2f,6.8f,8.3f};
		Commercial commercial=new Commercial(currentReading, previousReading, slabs);
		assertEquals(781.32f, commercial.computeBill());
	}

}

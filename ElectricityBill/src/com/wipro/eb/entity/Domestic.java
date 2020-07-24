package com.wipro.eb.entity;

public class Domestic extends Connection{
	public Domestic(int currentReading, int previousReading,float slabs[]) {
		super(currentReading, previousReading, slabs);
	}
	public float computeBill() {
		int units=getCurrentReading()-getPreviousReading();
		float ammount=0f;
		float[] slabs=getSlabs();
		int slabItr=0;
		{
			//first 50 
			if(units>0) {
				ammount+=(units<50?units:50)*slabs[slabItr];
			}
			slabItr++;
			units-=50;
			//next 50
			if(units>0) {
				ammount+=(units<50?units:50)*slabs[slabItr];
			}
			slabItr++;
			units-=50;
			//next 50
			if(units>0) {
				ammount+=units*slabs[slabItr];
			}
		}
		
		return ammount;
	}
}

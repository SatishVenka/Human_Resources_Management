package com.Maven;

import org.testng.annotations.Test;

public class Delete {

	@Test(groups="Smoke")
	public void delete()
	{
		System.out.println("----deleted---");
	}
	
	@Test(groups="Regression")
	public void explain()
	{
		System.out.println("-----explain---");
	}
}

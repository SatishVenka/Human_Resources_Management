package com.Maven;

import org.testng.annotations.Test;

public class Create {
@Test(groups="Regression")
public void create()
{
	System.out.println("---created new");
}

@Test(groups="Smoke")
public void details()
{
	System.out.println("-----detailes---");
}
}

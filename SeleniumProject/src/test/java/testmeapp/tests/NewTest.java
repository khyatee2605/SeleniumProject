package testmeapp.tests;

import java.util.Scanner;
import testmeapp.utility.*;

import org.testng.annotations.Test;

public class NewTest {
	Drivers d=new Drivers();
  @Test
  public void f() {
	  Scanner sc=new Scanner(System.in);
		System.out.println("Enter the browser");
		
		
	String name=sc.next();
	d.getDriver(name);
  }
}

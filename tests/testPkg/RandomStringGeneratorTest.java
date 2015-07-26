package testPkg;

import org.junit.Test;

import plist.RandomStringGenerator;

public class RandomStringGeneratorTest {
	
	
	@Test
	public void testGenerateAges() throws Exception {
		
		System.out.println("Generating Ages...");
		for(int i=0;i<=5;i++){
			System.out.println(RandomStringGenerator.
					generateRandomAge());
		}
	
	}
	
	@Test
	public void testGenerateGenders() throws Exception {
		
		System.out.println("Generating Genders...");
		for(int i=0;i<=5;i++){
			System.out.println(RandomStringGenerator.
					generateRandomGender());
		}
	
	}
	@Test
	public void testGenerateEnthnicities() throws Exception {
		
		System.out.println("Generating Ethinicities...");
		for(int i=0;i<=5;i++){
			System.out.println(RandomStringGenerator.
					generateRandomEthnicities());
		}
	
	}
	
	@Test
	public void testGenerateLocations() throws Exception {
		
		System.out.println("Generating Locations...");
		for(int i=0;i<=5;i++){
			System.out.println(RandomStringGenerator.
					generateRandomLocations());
		}
	
	}


}

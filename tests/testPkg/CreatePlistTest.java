package testPkg;

import java.util.ArrayList;

import org.junit.Test;

import plist.CreatePlist;
import plist.Location;
import plist.RandomStringGenerator;

public class CreatePlistTest {

	@Test
	public void testCreatePlist() throws Exception {

		ArrayList<Integer> ageList = new ArrayList<Integer>();
		ArrayList<Character> genderList = new ArrayList<Character>();
		ArrayList<String> ethnicityList = new ArrayList<String>();
		ArrayList<Location> locationList = new ArrayList<Location>();
		
		
		
		for (int i = 0; i < 10000; i++) {
			ageList.add(RandomStringGenerator.generateRandomAge());
			genderList.add(RandomStringGenerator.generateRandomGender());
			ethnicityList.add(RandomStringGenerator.generateRandomEthnicities());
			locationList.add(RandomStringGenerator.generateRandomLocations());
		}

	
		CreatePlist.CreateThePlist(genderList, ageList, ethnicityList,locationList);
	}

}

package plist;

import java.text.DecimalFormat;

public class RandomStringGenerator {

	public static Integer generateRandomAge() throws Exception {

		int minAge = 18;
		int maxAge = 61;

		int age = (int) Math.floor(Math.random() * (maxAge - minAge + 1)
				+ minAge);

		return age;
	}
	public static char generateRandomGender() throws Exception {
		
		String characters = "mf";
		int charactersLength = characters.length();
		double index = Math.random() * charactersLength;
		return characters.charAt((int)index);
	}
	public static String generateRandomEthnicities() throws Exception {
		
		String ethnicityArray[] = new String[6];
		
		ethnicityArray[0] = "Caucasian";
		ethnicityArray[1] = "African";
		ethnicityArray[2] = "Asian/Pacific Islander";
		ethnicityArray[3] = "Hispanic/Latino";
		ethnicityArray[4] = "Middle Eastern";
		ethnicityArray[5] = "Other";

		int arrayLength = ethnicityArray.length;

		double index = Math.random() * arrayLength;

		return (ethnicityArray[(int) index]);
	}
	public static Location generateRandomLocations() throws Exception {
		
		Location location = new Location();
	    double minLat = -77.0507;
		double maxLat = -77.1507;
		double latitude = minLat
				+ (double) (Math.random() * ((maxLat - minLat)));
		double minLon = 38.8856;
		double maxLon = 38.9010;
		double longitude = minLon
				+ (double) (Math.random() * ((maxLon - minLon)));
		DecimalFormat df = new DecimalFormat("#.####");
		
		location.latitude = df.format(latitude);
		location.longitude = df.format(longitude);
		return location;
	}
}
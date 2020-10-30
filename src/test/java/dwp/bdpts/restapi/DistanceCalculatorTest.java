package dwp.bdpts.restapi;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dwp.bdpts.restapi.distance.DistanceCalculator;
import dwp.bdpts.restapi.distance.GPSCoordinate;

@SpringBootTest
public class DistanceCalculatorTest {
	@Autowired
	DistanceCalculator distanceCalculator;

	// https://gps-coordinates.org/london-latitude.php
	GPSCoordinate LONDON = new GPSCoordinate(51.50722,-0.1275);				
	GPSCoordinate MANCHESTER = new GPSCoordinate(53.4808194, -2.2480118); 	// 163 miles from London
	GPSCoordinate BRIGHTON = new GPSCoordinate(50.8223627, -0.1376525);		// 47 miles from London
	
	@Test
	void distanceBetweenPointsInMilesTestIsZeroWhenIdenticalPoints() {
		double distance = distanceCalculator.distanceBetweenPointsInMiles(LONDON, LONDON);
		assertTrue(distance == 0.0);
	}
	
	@Test
	void distanceBetweenPointsInMilesTestIs163WhenLondonAndManchester() {
		double distance = distanceCalculator.distanceBetweenPointsInMiles(LONDON, MANCHESTER);
		assertTrue( (int) distance == 163);
	}

	@Test
	void distanceBetweenPointsInMilesIs47WhenLondonAndBrighton() {
		double distance = distanceCalculator.distanceBetweenPointsInMiles(LONDON, BRIGHTON);
		assertTrue( (int) distance == 47);
	}

	
}

package dwp.bdpts.restapi.distance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;
import net.sf.geographiclib.GeodesicMask;

@Service("DistanceCalculator")
public class DistanceCalculatorImpl implements DistanceCalculator {
	public Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	public double distanceBetweenPointsInMiles(GPSCoordinate pointA, GPSCoordinate pointB) {
		// https://mvnrepository.com/artifact/net.sf.geographiclib/GeographicLib-Java
		// https://geographiclib.sourceforge.io/html/java/net/sf/geographiclib/Geodesic.html		 
	 	final double METERS_TO_MILES_DIVISOR = 1609.344;

		GeodesicData geodesicData = Geodesic.WGS84.Inverse(pointA.getLatitude(), pointA.getLongitude(),
				pointB.getLatitude(), pointB.getLongitude(), GeodesicMask.DISTANCE);
		double metersApart = geodesicData.s12;
		double milesApart = metersApart / METERS_TO_MILES_DIVISOR;
		
		log.info("Distance between PointA " + pointA.toString() + " and PointB " + pointB.toString() + " in meters: " + metersApart + " in miles: " + milesApart);
		return milesApart;
	}

}

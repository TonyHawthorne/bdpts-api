package dwp.bdpts.restapi.distance;

public interface DistanceCalculator {
	public double distanceBetweenPointsInMiles(GPSCoordinate pointA, GPSCoordinate pointB);
}

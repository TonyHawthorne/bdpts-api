package dwp.bdpts.restapi.distance;

/**
 * Simple class to represent GPS Coordinates as two points: longitude and
 * latitude.
 * 
 * @author Tony
 * 
 */
public final class GPSCoordinate {
	private final double latitude;
	private final double longitude;

	public GPSCoordinate(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return "GPSCoordinate [latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}

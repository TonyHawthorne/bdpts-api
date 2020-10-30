package dwp.bdpts.restapi.distance;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dwp.bdpts.restapi.model.User;
import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;
import net.sf.geographiclib.GeodesicMask;

@Service("UserService")
public class UserServiceImpl implements UserService {
	@Autowired
	DistanceCalculator distanceCalculator;
	
	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	// https://gps-coordinates.org/london-latitude.php
	GPSCoordinate LONDON = new GPSCoordinate(51.50722, -0.1275);

	@Override
	public List<User> findUsersWithinNMilesOfLondon(int nMiles, User[] users) {
		List<User> foundUsers = new ArrayList<User>();

		log.info("Calculating proximity to London for " + users.length + " users");

		for (User user : users) {
			GPSCoordinate userPoint = new GPSCoordinate(user.getLatitute(), user.getLongitute());
			double distance = distanceCalculator.distanceBetweenPointsInMiles(LONDON, userPoint);

			log.info("distance from London: " + distance + " user: " + user.toString());
			
			if (distance <= nMiles) {
				foundUsers.add(user);
				log.info("User is within " + nMiles + " miles");
			}
			else {
				log.info("User is NOT within " + nMiles + " miles");
			}
		}

		return foundUsers;
	}

}

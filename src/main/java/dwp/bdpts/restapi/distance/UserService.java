package dwp.bdpts.restapi.distance;

import java.util.List;

import dwp.bdpts.restapi.model.User;

public interface UserService {
	List<User> findUsersWithinNMilesOfLondon(int miles, User[] users);
}

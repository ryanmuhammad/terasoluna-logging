package org.ryan.logging.domain.service.user;

import org.ryan.logging.domain.model.User;

import java.util.List;

/**
 * Created by Iriyanto.Perkasa on 1/23/2017.
 */
public interface UserService {
    User register(User user);
    User modify(User user);
    User delete(String userId);
    User findOne(String userId);
    List<User> findAll();
}

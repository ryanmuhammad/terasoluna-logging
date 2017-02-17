package org.ryan.logging.domain.service.user;

import org.ryan.logging.domain.common.logging.Auditable;
import org.ryan.logging.domain.model.User;
import org.ryan.logging.domain.repository.user.UserRepository;
import org.springframework.stereotype.Service;
import org.terasoluna.gfw.common.exception.BusinessException;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Iriyanto.Perkasa on 1/23/2017.
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;

    @Override
    @Auditable
    public User register(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    @Auditable
    public User modify(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    @Auditable
    public User delete(String userId) {
        User user = userRepository.findOne(userId);
        if (user != null) {
            userRepository.delete(userId);
            return user;
        } else {
            throw new BusinessException("User not found");
        }
    }

    @Override
    public User findOne(String userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}

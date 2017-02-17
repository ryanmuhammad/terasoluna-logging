package org.ryan.logging.domain.repository.user;

import org.ryan.logging.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Iriyanto.Perkasa on 1/23/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User,String> {

}

package com.wonders.xlab.data.repository.primary;

import com.wonders.xlab.data.entity.primary.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jeffrey on 15/10/21.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}

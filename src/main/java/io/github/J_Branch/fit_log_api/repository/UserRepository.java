package io.github.J_Branch.fit_log_api.repository;

import io.github.J_Branch.fit_log_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}

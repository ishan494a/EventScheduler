package com.ishan494a.eventschedulerapp.Repository;

import com.ishan494a.eventschedulerapp.Entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByEmail(String email);
}

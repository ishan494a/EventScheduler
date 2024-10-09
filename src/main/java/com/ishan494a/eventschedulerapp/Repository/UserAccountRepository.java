package com.ishan494a.eventschedulerapp.Repository;

import com.ishan494a.eventschedulerapp.DTO.UserAccountDTO;
import com.ishan494a.eventschedulerapp.Entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    UserAccount findByEmail(String email);
}

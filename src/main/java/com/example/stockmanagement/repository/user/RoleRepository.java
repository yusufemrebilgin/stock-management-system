package com.example.stockmanagement.repository.user;

import com.example.stockmanagement.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByName(String roleName);

}

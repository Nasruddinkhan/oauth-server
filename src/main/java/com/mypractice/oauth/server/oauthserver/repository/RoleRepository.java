package com.mypractice.oauth.server.oauthserver.repository;

import com.mypractice.oauth.server.oauthserver.entity.Role;
import com.mypractice.oauth.server.oauthserver.util.MapperUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
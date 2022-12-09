package com.mypractice.oauth.server.oauthserver.repository;

import com.mypractice.oauth.server.oauthserver.entity.ClientsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRegistrationRepository extends JpaRepository<ClientsDetails, String> {
}

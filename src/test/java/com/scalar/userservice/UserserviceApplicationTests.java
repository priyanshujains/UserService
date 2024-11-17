package com.scalar.userservice;

import com.scalar.userservice.security.repo.JpaRegisteredClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.test.annotation.Commit;

import java.util.UUID;

@SpringBootTest
class UserserviceApplicationTests {

	@Autowired
	JpaRegisteredClientRepository jpaRegisteredClientRepository;


	@Test
	void contextLoads() {
	}
//	@Test
//	@Commit
//	void storeregisteredclientinfo() {
//		RegisteredClient oidcClient = RegisteredClient.withId(UUID.randomUUID().toString())
//				.clientId("oidc-client")
//				.clientSecret("$2a$10$G96HnsFtVMqD/6nC1PxhzOUN4m/60W8.Kr.JCM1h.0IDDxCUqMZCK")
//				.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//				.authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//				.redirectUri("https://oauth.pstmn.io/v1/callback")
//				.postLogoutRedirectUri("https://oauth.pstmn.io/v1/callback")
//				.scope(OidcScopes.OPENID)
//				.scope(OidcScopes.PROFILE)
//				.scope("ADMIN")
//				.clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
//				.build();
//
//		 jpaRegisteredClientRepository.save(oidcClient);
//
//	}
}

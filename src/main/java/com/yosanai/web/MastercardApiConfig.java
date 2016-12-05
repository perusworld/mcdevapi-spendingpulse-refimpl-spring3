package com.yosanai.web;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.mastercard.api.core.ApiConfig;
import com.mastercard.api.core.security.oauth.OAuthAuthentication;

@Configuration
@PropertySource("mastercard-api.properties")
public class MastercardApiConfig {

	@Value("${mastercard.api.consumer.key}")
	private String consumerKey;

	@Value("${mastercard.api.key.alias}")
	private String keyAlias;

	@Value("${mastercard.api.keystore.password}")
	private String keyPassword;

	@Value("${mastercard.api.p12.path}")
	private Resource p12Path;

	@Value("${mastercard.api.sandbox}")
	private boolean sandbox;

	@Value("${mastercard.api.debug}")
	private boolean debug;

	@PostConstruct
	public void setupApiConfiguration() throws Exception {

		ApiConfig.setDebug(debug);
		ApiConfig.setSandbox(sandbox);

		ApiConfig.setAuthentication(
				new OAuthAuthentication(consumerKey, p12Path.getInputStream(), keyAlias, keyPassword));
	}
}

package com.example;

import java.net.URI;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.uri.UriBuilder;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;
import org.junit.jupiter.api.TestInstance;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@MicronautTest(environments = { "integration-test" }, rebuildContext = true)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DemoTest {

	@Inject
	private EmbeddedServer embeddedServer;

	@Inject
	private HttpClient client;

	@Test
	void testItWorks() {
		URI triggerNotificationsURI = UriBuilder.of(embeddedServer.getURI())
				.path("test")
				.build();

		HttpRequest request = HttpRequest.GET(triggerNotificationsURI);
		HttpResponse response = client
				.toBlocking()
				.exchange(request);

		assertTrue(response.getStatus() == HttpStatus.OK);
	}

	@Test
	void testItWorks2() {
		URI triggerNotificationsURI = UriBuilder.of(embeddedServer.getURI())
				.path("test")
				.build();

		HttpRequest request = HttpRequest.GET(triggerNotificationsURI);
		HttpResponse response = client
				.toBlocking()
				.exchange(request);

		assertTrue(response.getStatus() == HttpStatus.OK);
	}
}

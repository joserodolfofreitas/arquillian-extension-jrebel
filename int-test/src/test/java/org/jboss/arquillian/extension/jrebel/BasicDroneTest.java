package org.jboss.arquillian.extension.jrebel;

import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Arquillian.class)
public class BasicDroneTest {

	public static final int DEFAULT_IMPLICIT_WAIT_SECONDS = 5;

	private static final String WEBAPPDIR = "src/main/webapp";

	@Drone
	private static WebDriver driver = null;

	@ArquillianResource
	URL contextPath;

	@Deployment(testable = false)
	public static WebArchive getWebArchive() {

		WebArchive war = Packager.warWithInjectableArtifact();
		return war;
	}

	@Test
	public void fooTest() {
		System.out.println("foo");
	}

}

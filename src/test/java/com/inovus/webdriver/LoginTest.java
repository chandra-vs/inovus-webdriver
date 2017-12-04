package com.inovus.webdriver;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class LoginTest extends InovusWebdriver {
	
	@Test
	public void testLogin() {
		assertTrue(sleepForPageContains("USER NAME"));
		assertTrue(sleepForPageContains("PASSWORD"));
		login();
	}

}

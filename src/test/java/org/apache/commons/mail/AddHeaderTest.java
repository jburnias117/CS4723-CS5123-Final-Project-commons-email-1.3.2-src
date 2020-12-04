package org.apache.commons.mail;

import org.junit.Test;

import junit.framework.TestCase;

public class AddHeaderTest extends TestCase{
	Email testEmail;
	public void setUp() {
		testEmail = new SimpleEmail();
	}
	/*
	 * Tests addHeader with valid inputs
	 */
	@Test
	public void testAddHeaderTest() {
		// create name and value strings
		String name = "Name";
		String value = "Value";
		// add both strings to the header map
		testEmail.addHeader(name, value);
		assertTrue(testEmail.headers.containsKey(name));
		assertTrue(testEmail.headers.containsValue(value));
	}
	
	/*
	 * Tests addHeader with an empty name
	 */
	@Test
	public void testAddHeaderTestEmptyName() {
		// create empty name and value strings
		String name = "";
		String value = "Value";
		try {
			// add strings to header map; expected to fail due to empty name
			testEmail.addHeader(name, value);
			fail("Failed due to empty name");
		} catch (Exception e) {
			
		}
	}
	
	/*
	 * Tests addHeader with a null name
	 */
	@Test
	public void testAddHeaderTestNullName() {
		// create null name and value strings
		String name = null;
		String value = "Value";
		try {
			// add strings to header map; expected to fail due to null name
			testEmail.addHeader(name, value);
			fail("Failed due to null name");
		} catch (Exception e) {
			
		}
	}

}

package org.apache.commons.mail;

import org.junit.Test;

import junit.framework.TestCase;

public class BuildMimeMessageTest extends TestCase{
	Email testEmail;
	public void setUp() {
		testEmail = new SimpleEmail();
	}
	/*
	 *  Tests buildMimeMessage for mime message already being built
	 */
	@Test
	public void testBuildMimeMessageBuilt() throws EmailException {
		try {
			testEmail.setHostName("HostName");
			testEmail.addTo("A@B.com");
			testEmail.setFrom("C@D.com");
			testEmail.addCc("E@F.com");
			testEmail.addBcc("G@H.com");
			testEmail.buildMimeMessage();
			testEmail.buildMimeMessage();
		} catch (IllegalStateException e) {
			assertEquals("The MimeMessage is already built.", e.getMessage());
		}
	}
	
	/*
	 *  Tests buildMimeMessage for subject but no charset
	 */
	@Test
	public void testBuildMimeMessageMsgSubjectOnly() throws EmailException {
		testEmail.setHostName("HostName");
		testEmail.addTo("A@B.com");
		testEmail.setFrom("C@D.com");
		testEmail.setSubject("Subject");
		testEmail.buildMimeMessage();
		assertTrue(EmailUtils.isNotEmpty(testEmail.subject));
		assertTrue(EmailUtils.isEmpty(testEmail.charset));
	}
	
	/*
	 *  Tests buildMimeMessage for both subject and charset
	 */
	@Test
	public void testBuildMimeMessageMsgSubjectAndCharset() throws EmailException {
		testEmail.setHostName("HostName");
		testEmail.addTo("A@B.com");
		testEmail.setFrom("C@D.com");
		testEmail.setSubject("Subject");
		testEmail.setCharset("UTF-8");
		testEmail.buildMimeMessage();
		assertTrue(EmailUtils.isNotEmpty(testEmail.subject));
		assertTrue(EmailUtils.isNotEmpty(testEmail.charset));
	}
}

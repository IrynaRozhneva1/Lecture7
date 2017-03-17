package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ui.pages.EmailPage;
import ui.pages.InboxPage;
import ui.pages.NewEmailPage;
import ui.pages.SignInPage;
import ui.pages.SpamPage;



public class PageFactoryTest extends BaseTest {

	private SignInPage signInPage;
	private InboxPage inboxPage;
	private NewEmailPage newEmail;
	private EmailPage emailPage;
	private SpamPage spamPage;
	
	@Parameters({"username1", "password1", "recipientEmail", "subject1", "messageText" })
	@Test(description = "Write a new email", priority = 0)
	public void writeNewEmailWithSubject1(String username1, String password1, String recipientEmail, String subject1, String messageText) {
		login(username1, password1);
		writeNewEmail(recipientEmail, subject1, messageText);
		startPage = newEmail.exitFromAccount();
	}

	@Parameters({"username2", "password2"})
	@Test(description = "Mark email from user1 as spam", priority = 1)
	public void markEmailAsSpam(String username2, String password2) {
		login(username2, password2);
		emailPage = inboxPage.openEmail();
		inboxPage = emailPage.markAsSpam();
		startPage = newEmail.exitFromAccount();
	}

	@Parameters({"username1", "password1", "recipientEmail", "subject2", "messageText" })
	@Test(description = "Write a new email1", priority = 2)
	public void writeNewEmail1(String username1, String password1, String recipientEmail, String subject2, String messageText) {
		login(username1, password1);
		writeNewEmail(recipientEmail, subject2, messageText);
		startPage = newEmail.exitFromAccount();
	}
	
	@Parameters({"username2", "password2", "subject2"})
	@Test(description = "Go to spam and compare user name", priority = 3)
	public void compareUserNameInSpam(String username2, String password2, String subject2) {
		login(username2, password2);
		spamPage = inboxPage.openSpam();
		String userSubjFromEmail = spamPage.getSpamSubject();
		Assert.assertEquals(subject2, userSubjFromEmail, "Mail with subject '" + subject2 + "' was not found!");
	}
	
	public void login(String user, String password) {
		signInPage = startPage.invokeSignIn();
		inboxPage = signInPage.signIn(user, password);
	}
	
	public void writeNewEmail(String recipientEmail, String subject, String messageText) {
		newEmail = inboxPage.invokeNewMessage();
		newEmail.sendEmail(recipientEmail, subject, messageText);
	}
}
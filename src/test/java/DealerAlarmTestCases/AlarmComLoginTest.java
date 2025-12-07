package DealerAlarmTestCases;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.AlarmLoginPage;

public class AlarmComLoginTest extends BaseClassAlarmTest {

	private static final Logger log = LogManager.getLogger(AlarmComLoginTest.class);

	@Test
	public void LoginAlarm() throws Throwable {
		AlarmLoginPage alarmLogin = new AlarmLoginPage(dri); // dri is from BaseClassAlarmTest
		alarmLogin.enterUsername(username);
		alarmLogin.clickLoginButton();
		alarmLogin.getNoPasswordMessage();

		alarmLogin.clickRememberMeCheckbox();
		alarmLogin.clickShowPassword();

		alarmLogin.enterPassword("ABC");
		Thread.sleep(5000);

		alarmLogin.getForgotUsernameText();

		alarmLogin.clickLoginButton();

		alarmLogin.getRememberMeLabel();
		alarmLogin.getSSOText();
		alarmLogin.getLoginFailedMessage();
		alarmLogin.enterPassword(password);
		alarmLogin.clickLoginButton();
		Thread.sleep(10000);

		log.info("Login test executed successfully");

	}

}

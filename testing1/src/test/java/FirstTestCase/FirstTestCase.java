package FirstTestCase;

import org.testng.annotations.Test;

import BaseSetup.BaseSetup;

public class FirstTestCase extends BaseSetup{

	@Test
	public void FirstCase() {
		NavigateToWebsite();
	}
}

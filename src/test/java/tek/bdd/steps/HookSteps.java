package tek.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import tek.bdd.utility.SeleniumUtilities;

public class HookSteps extends SeleniumUtilities {

    @Before
    public void initiateTest(){
        openBrowser();
    }

    @After
    public void closingTest(Scenario scenario){

        if(scenario.isFailed()) {
            TakesScreenshot screenshot = (TakesScreenshot) getDriver();
            byte[] capture = screenshot.getScreenshotAs(OutputType.BYTES);

            scenario.attach(capture, "image/png", "screenshot");
        }

        getDriver().quit();
    }
}

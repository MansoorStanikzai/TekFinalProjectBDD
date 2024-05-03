package tek.bdd.steps;

import io.cucumber.java.en.Given;
import tek.bdd.page.HomePage;
import tek.bdd.utility.SeleniumUtilities;

public class NavigateSteps extends SeleniumUtilities {
    @Given("Navigate to Create Primary Account Page by clicking the Button")
    public void navigateCreatePrimaryAccountPage() {
        clickElement(HomePage.PRIMARY_ACCOUNT_BTN);
    }
}

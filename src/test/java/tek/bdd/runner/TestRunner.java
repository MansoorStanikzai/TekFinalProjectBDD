package tek.bdd.runner;

import io.cucumber.core.options.CucumberOptionsAnnotationParser;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "tek.bdd.steps",
        dryRun = false,
        //tags ="",
        plugin = {
                "html:target/html_report/index.html",
                "json:target/jsonReports/report.json"
        }
)

public class TestRunner {

}
